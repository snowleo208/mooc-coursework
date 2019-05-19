(* Dan Grossman, Coursera PL, HW2 Provided Code *)

(* if you use this function to compare two strings (returns true if the same
   string), then you avoid several of the functions in problem 1 having
   polymorphic types that may be confusing *)
fun same_string(s1 : string, s2 : string) =
    s1 = s2

(* put your solutions for problem 1 here *)
fun all_except_option (str: string, []) = NONE
  | all_except_option (str, x :: xs) = 
    case same_string(x, str) of 
      true  => SOME xs
    | false => case all_except_option(str, xs) of 
                 NONE   => NONE
		| SOME y => SOME (x::y)

fun get_substitutions1 (lst: string list list, s: string) =
  case lst of
      [] => []
    | lst::xs' => case all_except_option (s, lst) of
		      NONE => get_substitutions1(xs', s)
		   |  SOME l => l @ get_substitutions1 (xs',s)

fun get_substitutions2 (lst: string list list, s: string) =
  let
      fun helper (s: string, lst: string list list, res: string list) =
	case lst of
	    [] => res
	  | lst::xs' => case all_except_option (s, lst) of
			    NONE => helper(s, xs', res)
			  | SOME first_item => helper(s, xs', res @ first_item)
  in
      helper(s, lst, [])
  end

fun similar_names(lst: string list list, {first=f, middle=m, last=l}) =
  let
      fun helper (name_list: string list) =
	case name_list of
	    [] => []
	  | x::xs' => {first= x, middle= m, last= l} :: helper(xs')
  in
      {first=f, middle=m, last=l} :: helper (get_substitutions2(lst, f))
  end

(* you may assume that Num is always used with values 2, 3, ..., 10
   though it will not really come up *)
datatype suit = Clubs | Diamonds | Hearts | Spades
datatype rank = Jack | Queen | King | Ace | Num of int 
type card = suit * rank

datatype color = Red | Black
datatype move = Discard of card | Draw 

exception IllegalMove

(* put your solutions for problem 2 here *)

fun card_color (c: card) =
  case c of
      (Spades,_) => Black
    | (Clubs,_) => Black
    | (Diamonds,_) => Red
    | (Hearts,_) => Red

fun card_value (c: card) =
  case c of
      (_,Ace) => 11
    | (_,Num n) => n 
    | (_,_) => 10

fun remove_card(cs : card list, c : card, exc) =
    case cs of
	  [] => raise exc
	| x::xs' => if x = c
		    then xs'
		    else x::remove_card(xs', c, exc) 

fun all_same_color (cs: card list) =
  case cs of
      [] => true
    | _::[] => true 
    | c1::(c2::rest) => case card_color(c1) = card_color(c2) of
			    true => all_same_color(c2::rest)
			  | false => false

fun sum_cards (cs: card list) =
  let
      fun sum(cs: card list, total) =
	case cs of
	    [] => total
	  | x::xs' => sum(xs', total + card_value(x))
  in
      sum(cs, 0)
  end

fun score (cs: card list, goal: int) =
  let
      val total = sum_cards(cs)
      val preliminary = if total > goal
		       then (3 * (total - goal))
		       else (goal - total)
  in
      if all_same_color(cs)
      then preliminary div 2
      else preliminary
  end

fun officiate(cs: card list, moves: move list, goal: int) = 
    let fun status (curr_card: card list, cs: card list, ml: move list) = 
            case ml of
                 [] => score(curr_card, goal)
               | (Discard c)::tail => status(remove_card(curr_card, c, IllegalMove), cs, tail)
               | Draw::tail => case cs of
                                    [] => score(curr_card, goal)
                                  | x::rest => if sum_cards(x::curr_card) > goal
                                             then score(x::curr_card, goal)
                                             else status(x::curr_card,rest, tail)
    in
        status([], cs, moves)
end
