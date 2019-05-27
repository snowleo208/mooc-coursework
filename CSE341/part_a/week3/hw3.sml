(* Coursera Programming Languages, Homework 3, Provided Code *)

exception NoAnswer

datatype pattern = Wildcard
		 | Variable of string
		 | UnitP
		 | ConstP of int
		 | TupleP of pattern list
		 | ConstructorP of string * pattern

datatype valu = Const of int
	      | Unit
	      | Tuple of valu list
	      | Constructor of string * valu

fun g f1 f2 p =
    let 
	val r = g f1 f2 
    in
	case p of
	    Wildcard          => f1 ()
	  | Variable x        => f2 x
	  | TupleP ps         => List.foldl (fn (p,i) => (r p) + i) 0 ps
	  | ConstructorP(_,p) => r p
	  | _                 => 0
    end

(**** for the challenge problem only ****)

datatype typ = Anything
	     | UnitT
	     | IntT
	     | TupleT of typ list
	     | Datatype of string

(**** you can put all your code here ****)

(* Problem 1 *)
fun only_capitals (lst: string list) =
  List.filter(fn x => Char.isUpper(String.sub(x,0))) lst

(* Problem 2 *)
fun longest_string1 (lst: string list) =
  foldl(fn (x, y) => if String.size(x) <= String.size(y)
		     then y
		     else x) "" lst;

(* Problem 3 *)
fun longest_string2 lst  =
  foldl (fn (x,y) => if String.size x >= String.size y then x else y) "" lst

(* Problem 4 *)
fun longest_string_helper f lst =
  foldl (fn (x,y) => if f(String.size x, String.size y) then x else y) "" lst

val longest_string3 = 
    longest_string_helper (fn (x,y) => x > y)
 
val longest_string4 =
    longest_string_helper (fn (x,y) => x >= y)

(* Problem 5 *)
val longest_capitalized = longest_string1 o only_capitals;

(* Problem 6 *)
val rev_string = String.implode o rev o String.explode;

(* Problem 7 *)
fun first_answer func ls =
  case ls of
      [] => raise NoAnswer
    | x::xs => (case func(x) of
		   NONE => first_answer func xs
		 | SOME x => x)

(* Problem 8 *)
fun all_answers f ls =
  let
      val not_existed = List.exists(fn x => f(x) = NONE)
      val final = List.foldl (fn(x,acc)  => (case f(x) of
						 SOME y => y @ acc
					       | _ => acc ))
  in
      case ls of
	  [] => SOME []
	| _ => if not_existed ls
	       then NONE
	       else SOME (final [] ls)
  end

(* Problem 9a *)
val count_wildcards = g (fn () => 1) (fn x => 0);

(* Problem 9b *)
val count_wild_and_variable_lengths = g( fn () => 1) (fn x => String.size x);

(* Problem 9c *)
fun count_some_var (s, p) = g (fn () => 0) (fn x => if x = s
						    then 1
						    else 0) p;

(* Problem 10 *)
fun check_pat p =
  let
      fun str_list p =
	case p of
	    Variable x => [x]
	  | TupleP t => List.foldl(fn (x, acc) => str_list(x) @acc) [] t
	  | _ => []
      fun is_repeat x = List.exists(fn y => x = y)
      fun unique lst =
	case lst of
	    [] => true
	  | x::xs => if(is_repeat x xs)
		     then false
		     else unique xs
  in
      unique(str_list p)
  end

(* Problem 11 *)
fun match (v, p) =
  case (v,p) of
      (_, Wildcard) => SOME []
    | (Const v, ConstP p) => if v = p
			       then SOME []
			       else NONE
    | (Unit, UnitP) => SOME []
    | (Constructor(s1,v1), ConstructorP(s2,p1)) => if s1 = s2
						   then match (v1, p1)
						   else NONE
    | (Tuple v, TupleP p) => if List.length v = List.length p
			      then all_answers (fn (vs, ps) =>  match (vs, ps)) (ListPair.zip(v,p))
			      else NONE
    | (_, Variable s) => SOME [(s,v)]
    | (_,_) => NONE

(* Problem 12 *)
fun first_match v p =
    SOME (first_answer (fn p => match(v,p)) p)
    handle NoAnswer => NONE
