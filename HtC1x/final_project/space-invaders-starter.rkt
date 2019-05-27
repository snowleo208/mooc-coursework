;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-abbr-reader.ss" "lang")((modname space-invaders-starter) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
(require 2htdp/universe)
(require 2htdp/image)

;; Space Invaders

;; =========================
;; Constants:

(define WIDTH  300)
(define HEIGHT 500)

(define INVADER-X-SPEED 1.5)  ;speeds (not velocities) in pixels per tick
(define INVADER-Y-SPEED 1.5)
(define TANK-SPEED 2)
(define MISSILE-SPEED 10)

(define HIT-RANGE 10)

(define INVADE-RATE 30)

(define BACKGROUND (empty-scene WIDTH HEIGHT))

(define INVADER
  (overlay/xy (ellipse 10 15 "outline" "blue")              ;cockpit cover
              -5 6
              (ellipse 20 10 "solid"   "blue")))            ;saucer

(define TANK
  (overlay/xy (overlay (ellipse 28 8 "solid" "black")       ;tread center
                       (ellipse 30 10 "solid" "green"))     ;tread outline
              5 -14
              (above (rectangle 5 10 "solid" "black")       ;gun
                     (rectangle 20 10 "solid" "black"))))   ;main body

(define TANK-HEIGHT/2 (/ (image-height TANK) 2))

(define MISSILE (ellipse 5 15 "solid" "red"))


;; =========================
;; Data Definitions:

(define-struct game (invaders missiles tank))
;; Game is (make-game  (listof Invader) (listof Missile) Tank)
;; interp. the current state of a space invaders game
;;         with the current invaders, missiles and tank position

;; Game constants defined below Missile data definition

#;
(define (fn-for-game s)
  (... (fn-for-loinvader (game-invaders s))
       (fn-for-lom (game-missiles s))
       (fn-for-tank (game-tank s))))

(define-struct tank (x dir))
;; Tank is (make-tank Number Integer[-1, 1])
;; interp. the tank location is x, HEIGHT - TANK-HEIGHT/2 in screen coordinates
;;         the tank moves TANK-SPEED pixels per clock tick left if dir -1, right if dir 1

(define T0 (make-tank (/ WIDTH 2) 1))   ;center going right
(define T1 (make-tank 50 1))            ;going right
(define T2 (make-tank 50 -1))           ;going left
(define T3 (make-tank 0 -1))           ;screen edge
(define T4 (make-tank WIDTH 1))           ;screen edge

#;
(define (fn-for-tank t)
  (... (tank-x t) (tank-dir t)))


(define-struct invader (x y dx))
;; Invader is (make-invader Number Number Number)
;; interp. the invader is at (x, y) in screen coordinates
;;         the invader along x by dx pixels per clock tick

(define I1 (make-invader 150 100 12))           ;not landed, moving right
(define I2 (make-invader 150 HEIGHT -10))       ;exactly landed, moving left
(define I3 (make-invader 150 (+ HEIGHT 10) 10)) ;> landed, moving right


#;
(define (fn-for-invader invader)
  (... (invader-x invader) (invader-y invader) (invader-dx invader)))


;;ListOfInvader is one of:
;; - empty
;; - (cons invader ListOfInvader)
;; interp. a list of invaders

(define LOI1 empty)
(define LOI2 (list I1))
(define LOI3 (list I1 I2 I3))
#;
(define (fn-for-loi loi)
  (cond[(empty? loi) (...)]
       [else
        (... (fn-for-invader (first loi))
             (fn-for-loi (rest loi)))]))


(define-struct missile (x y))
;; Missile is (make-missile Number Number)
;; interp. the missile's location is x y in screen coordinates

(define M1 (make-missile 150 300))                       ;not hit U1
(define M2 (make-missile (invader-x I1) (+ (invader-y I1) 10)))  ;exactly hit U1
(define M3 (make-missile (invader-x I1) (+ (invader-y I1)  5)))  ;> hit U1

#;
(define (fn-for-missile m)
  (... (missile-x m) (missile-y m)))

;; ListOfMissile is one of:
;; - empty
;; (cons missile ListOfMissile)
;;interp. a list of missiles that exist in the game

(define LOM1 empty)
(define LOM2 (list M1))
(define LOM3 (list M1 M2 M3))
#;
(define (fn-for-lom lom)
  (cond[(empty? lom) (...)]
       [else
        (... (fn-for-missile (first lom))
             (fn-for-lom (rest lom)))]))

(define G0 (make-game empty empty T0))
(define G1 (make-game empty empty T1))
(define G2 (make-game (list I1) (list M1) T1))
(define G3 (make-game (list I1 I2) (list M1 M2) T1))

;; =========================
;; Functions


;; Game -> Game
;; render the Space Invaders game with tank and cockpit

(define (main g)
  (big-bang g                            ; Game
    (on-tick   gen-game)                 ; Game -> Game
    (to-draw   render)                   ; Game -> Image
    (on-key    move-tank)))              ; Game KeyEvent -> Game
;    (stop-when ...)))                   ; WS -> Boolean


;; Game -> Game
;; generate game's state
;(check-expect (gen-game G0) (make-game empty empty (make-tank (+ (/ WIDTH 2) TANK-SPEED) 1))) ;only tamk
;(check-expect (gen-game G3) (make-game (list empty
;                                             (make-invader (+ (invader-x I2) INVADER-X-SPEED)
;                                                           (+ (invader-y I2) INVADER-Y-SPEED) (invader-dx I2)))
;                                       (list (make-missile (missile-x M1) (+ (missile-y M1) MISSILE-SPEED)) empty)
;                                       (make-tank (+ (/ WIDTH 2) TANK-SPEED) 1)))

;(define (gen-game g) g)  ;stub

(define (gen-game g)
  (make-game (remove-invader (create-invader (game-invaders g)) (game-missiles g))
             (remove-missile (game-missiles g) (game-invaders g))
             (gen-tank g)))

;; ListOfInvaders, ListOfMissles -> ListOfInvaders
;; remove invader if it was hit by missile and move invader
(check-expect (remove-invader (game-invaders G0) (game-missiles G0)) empty) ;no hit
(check-expect (remove-invader (game-invaders G2) (game-missiles G2))
              (list
               (make-invader (+ (invader-x I1) (* INVADER-X-SPEED (invader-dx I1)))
                             (+ (invader-y I1) INVADER-Y-SPEED) (invader-dx I1)))) ;no hit
(check-expect (remove-invader (game-invaders G3) (game-missiles G3))
              (list empty
                    (make-invader (+ (invader-x I2) (* INVADER-X-SPEED (invader-dx I2)))
                                  (+ (invader-y I2) INVADER-Y-SPEED) (invader-dx I2)))) ;remove 1 invader

;(define (remove-invader loi lom) loi) ;stub

(define (remove-invader loi lom)
  (cond [(empty? lom) loi] ;missile is empty
        [(empty? loi) empty] ;no invaders
        [else
         (cons (move-invader (first loi) lom)
               (remove-invader (rest loi) lom))
         ]))


;; Invader, ListOfMissles -> Invader
;; helper function to move invader each tick and remove if it was hit by missile

(check-expect (move-invader empty (game-missiles G0)) empty) ;no hit
(check-expect (move-invader (make-invader 150 100 12) (list M1))
              (make-invader (+ 150 (* INVADER-X-SPEED (invader-dx I1))) (+ 100 INVADER-Y-SPEED) 12)) ;no hit, move right
(check-expect (move-invader (make-invader WIDTH 100 12) (list M1))
              (make-invader (+ WIDTH (* -12 INVADER-X-SPEED)) (- 100 INVADER-Y-SPEED) -12)) ;no hit, move left as it hits screen edge
(check-expect (move-invader I1 (list M1 M2 M3)) empty) ;remove invader

;(define (move-invader i lom) empty) ;stub

(define (move-invader i lom)
  (cond [(empty? i) empty]
        [(empty? lom) (amend-invader i)]
        [else
         (if (or (and (= (invader-x i) (missile-x (first lom) )) (or (= (+ (invader-y i)  10) (missile-y (first lom) ))
                                                                 (= (+ (invader-y i)  5) (missile-y (first lom) ))))
                 (< (invader-y i) 0))
             empty
             (move-invader i (rest lom)))
         ]))


;; Invader -> Invader
;; helper function to create invader with new coordinates
(check-expect (amend-invader empty) empty)
(check-expect (amend-invader (make-invader WIDTH 100 12))
              (make-invader (+ WIDTH (* -12 INVADER-X-SPEED)) (- 100 INVADER-Y-SPEED) -12)) ;move opposite when hit screen edge
(check-expect (amend-invader (make-invader 130 100 12))
              (make-invader (+ 130 (* 12 INVADER-X-SPEED)) (+ 100 INVADER-Y-SPEED) 12)) ;move same direction


;(define (amend-invader i) empty) ;stub

(define (amend-invader i)
  (cond [(empty? i) empty]
        [(> (+ (invader-x i) (* (invader-dx i) INVADER-X-SPEED)) WIDTH)  ;move opposite position if > width
         (make-invader (+ WIDTH (* (- (invader-dx i)) INVADER-X-SPEED)) (- (invader-y i) INVADER-Y-SPEED) (- (invader-dx i)))]
        [else
         (make-invader
          (+ (invader-x i) (* INVADER-X-SPEED (invader-dx i))) (+ (invader-y i) INVADER-Y-SPEED) (invader-dx i))]))


;; ListOfInvader -> ListOfInvader
;; produce the next invader randomly to current state of ListOfInvader

(define (create-invader loi)
  (cond[(< (random 150) INVADE-RATE)
        (cons (make-invader (random WIDTH) 0 (random 12)) loi)]
       [else loi]))


;; ListOfMissles, ListOfInvaders -> ListOfMissle
;; change missile per tick
;;!!!
(check-expect (remove-missile empty (list I1)) empty) ;no missile
(check-expect (remove-missile (list M1) (list I1))
              (list (make-missile (missile-x M1) (- (missile-y M1) MISSILE-SPEED)))) ;not hit
(check-expect (remove-missile (list M1 M2) (list I1 I2))
              (list (make-missile (missile-x M1) (- (missile-y M1) MISSILE-SPEED)) empty)) ;hit 1

;(define (remove-missile lom loi) empty) ;stub

(define (remove-missile lom loi)
  (cond[(empty? lom) empty]
       [else
        (cons (move-missile (first lom) loi)
              (remove-missile (rest lom) loi))]))



;; Missle -> Missle
;; move missile from tank to top of the screen or remove if it hit invader
(check-expect (move-missile empty (list I1)) empty) ;no missile
(check-expect (move-missile M1 (list I1)) (make-missile (missile-x M1) (- (missile-y M1) MISSILE-SPEED))) ;move missile
(check-expect (move-missile M2 (list I1)) empty) ;remove missile

;(define (move-missile m loi) empty) ;stub

(define (move-missile m loi)
  (cond [(empty? m) empty]
        [(empty? loi) (make-missile (missile-x m) (- (missile-y m) MISSILE-SPEED))]
        [else
         (if (or (and (= (missile-x m) (invader-x (first loi) )) (or (= (missile-y m) (+ (invader-y (first loi))  10) )
                                                                 (= (missile-y m) (+ (invader-y (first loi))  5))))
                 (< (missile-y m) 0))
             empty
             (move-missile m (rest loi))
             )]))


;; Tank -> Tank
;; move invader per tick, to left or right based on dir
(check-expect (gen-tank G3) (make-tank (+ 50 TANK-SPEED) 1)) ;move right
(check-expect (gen-tank (make-game (list I1 I2 I3) (list M1 M2) T2)) (make-tank (- 50 TANK-SPEED) -1)) ;move left
(check-expect (gen-tank (make-game (list I1 I2) (list M1 M2) T3)) T3) ;0
(check-expect (gen-tank (make-game (list I1 I2) (list M1 M2) T4)) T4) ;width
(check-expect (gen-tank (make-game (list I1 I2) (list M1 M2) (make-tank 0 -1))) (make-tank 0 -1)) ;0

;(define (gen-tank g) g)  ;stub

(define (gen-tank g)
  (cond [(or (and (> (tank-x (game-tank g)) (- WIDTH TANK-HEIGHT/2)) (= (tank-dir (game-tank g)) 1)) ;right edge
             (and (< (tank-x (game-tank g)) TANK-HEIGHT/2) (= (tank-dir (game-tank g)) -1)))  ;left edge
         (game-tank g)] ;stop
        [(= (tank-dir (game-tank g)) 1)
         (make-tank (+ (tank-x (game-tank g)) TANK-SPEED) (tank-dir (game-tank g)))] ;right
        [else
         (make-tank (- (tank-x (game-tank g)) TANK-SPEED) (tank-dir (game-tank g)))])) ;left




;; Game -> Image
;; create all elements on screen
(check-expect (render (make-game empty empty empty)) BACKGROUND) ;empty
(check-expect (render G2) (place-images (list INVADER
                                              MISSILE
                                              TANK)
                                        (list (make-posn  (invader-x I1) (invader-y I1))
                                              (make-posn  (missile-x M1) (missile-y M1))
                                              (make-posn  (tank-x T1) (- HEIGHT TANK-HEIGHT/2)))
                                        BACKGROUND))

;(define (render g) BACKGROUND) ;stub

(define (render g)
  (cond [(and (empty? (game-invaders g))
              (empty? (game-missiles g))
              (empty? (game-tank g)) ) BACKGROUND]
        [else
         (place-images (append (cons TANK (render-image-list (game-invaders g)))
                               (render-image-list (game-missiles g)))
                       (append (cons (make-posn (tank-x (game-tank g)) (- HEIGHT TANK-HEIGHT/2))
                                     (render-pos-list (game-invaders g)))
                               (render-pos-list (game-missiles g)))
                       BACKGROUND)]))

;; List -> List
;; produce position lists from game for images
(check-expect (render-pos-list empty) empty)
(check-expect (render-pos-list (list M1)) (list (make-posn  (missile-x M1) (missile-y M1))))
(check-expect (render-pos-list (list I1 I2)) (list (make-posn  (invader-x I1) (invader-y I1))
                                                   (make-posn  (invader-x I2) (invader-y I2))))

;(define (render-pos-list l) empty)

(define (render-pos-list lst)
  (cond [(empty? lst) empty]
        [(invader? (first lst)) (cons (make-posn (invader-x (first lst)) (invader-y (first lst)))
                                      (render-pos-list (rest lst)))]
        [(missile? (first lst)) (cons (make-posn (missile-x (first lst)) (missile-y (first lst)))
                                      (render-pos-list (rest lst)))]
        ))


;; List -> List
;; produce lists from game for images
(check-expect (render-image-list empty) empty)
(check-expect (render-image-list (list M1)) (list MISSILE))
(check-expect (render-image-list (list I1 I2)) (list INVADER INVADER))

;(define (render-image-list l) empty)

(define (render-image-list lst)
  (cond [(empty? lst) empty]
        [(invader? (first lst)) (cons INVADER 
                                      (render-image-list (rest lst)))]
        [(missile? (first lst)) (cons MISSILE 
                                      (render-image-list (rest lst)))]
        [else (cons empty (render-image-list (rest lst)))]))


;; Game KeyEvent -> Game
;; move tank to left or right and shot missles
(check-expect (move-tank G3 "k") G3) ;wrong key
(check-expect (move-tank G3 "left") (make-game (game-invaders G3) (game-missiles G3)
                                               (make-tank (tank-x (game-tank G3)) -1))) ;left
(check-expect (move-tank G3 "right") (make-game (game-invaders G3) (game-missiles G3)
                                                (make-tank (tank-x (game-tank G3)) 1))) ;right
(check-expect (move-tank G3 " ") (make-game (game-invaders G3)
                                            (cons (make-missile (tank-x (game-tank G3)) (- HEIGHT 10)) (game-missiles G3))
                                            (game-tank G3))) ;space: create missile

;(define (move-tank g kevt) g) ;stub

(define (move-tank g kevt)
  (cond [(key=? "left" kevt) (make-game (game-invaders g) (game-missiles g)
                                        (make-tank (tank-x (game-tank g)) -1))]
        [(key=? "right" kevt) (make-game (game-invaders g) (game-missiles g)
                                         (make-tank (tank-x (game-tank g)) 1))]
        [(key=? " " kevt) (make-game (game-invaders g)
                                     (cons (make-missile (tank-x (game-tank g)) (- HEIGHT 10)) (game-missiles g))
                                     (game-tank g))]
        [else
         g]))


;; Game -> Boolean
;; Stop the game when invader reaches the bottom of the screen

