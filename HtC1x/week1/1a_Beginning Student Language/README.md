# Week 1

Learning Beginning Student Language (BSL) with some decent functions:

```racket
(+ 1 2)
(sqr 3) ;get 9
(sqrt 16) ;get 4
```

## String

(string-append "Hello" " " " World") ;get "Hello World"
(string-substring "012345678" 2 4) ;get 23

Numbers and string are not same, so `(+ 3 "123")` prints error.

## Image

You can create images also! For example:

```racket
(require 2htdp/image)

(circle 10 "solid" "red") ;print a red circle
(rectangle 30 60 "outline" "blue") ;print a rectangle w30 x h60 with blue border

(text "hello" 24 "orange") ;an image text sized 24px in orange color

(above (circle 10 "solid" "red")
       (circle 20 "solid" "yellow")
       (circle 30 "solid" "green")) ; print three circles from top to bottom

(beside (circle 10 "solid" "red")
       (circle 20 "solid" "yellow")
       (circle 30 "solid" "green")) ; print three circles, but in a row

(overlay (circle 10 "solid" "red")
         (circle 20 "solid" "yellow")
         (circle 30 "solid" "green")) ; print one circles, with red in the middle, then yellow and green
```


## Constants

Create variables like this:

```racket
; (define <NAME> <EXPRESSION>)
(define WIDTH 400)
(define HEIGHT 600)

(* WIDTH HEIGHT) ;get final answer 24000

```

## Function

Create function like this:

```racket
(define (large x y)
  (if (> x y)
      x
      y))

(large 4 10)

; return 10

```

## Booleans

Booleans:

`true` or `false`.

Compare: 

```racket
(define WIDTH 100)
(define HEIGHT 100)

(> WIDTH HEIGHT) ;false
(>= WIDTH HEIGHT) ;true
(= WIDTH HEIGHT) ;true
```

## IF Expressions

```racket
(if <EXPRESSION>
       <EXPRESSION> ;if true, do this
       <EXPRESSION>)  ;if false, do this

```

## Stepper

Use the stepper built in DrRacket to show each step of your function.