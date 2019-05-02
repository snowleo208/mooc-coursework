(* Homework1 Simple Test *)
(* These are basic test cases. Passing these tests does not guarantee that your code will pass the actual homework grader *)

fun is_older (a: (int * int * int), b: (int * int * int)): bool =
  if #1 a = #1 b
  then
    if #2 a < #2 b
	   then true
	   else #3 a < #3 b
  else #1 a < #1 b;

fun number_in_month (d: (int * int * int) list, m: int): int =
  if null d
  then 0
  else
      if #2 (hd d) = m
      then number_in_month(tl d, m) + 1
      else number_in_month(tl d, m);

fun number_in_months (d: (int * int * int) list, m: int list): int =
  if null m then 0
  else number_in_month(d, hd m) + number_in_months(d, tl m);

fun dates_in_month (d: (int * int * int) list, m: int) =
  if null d
  then []
  else
      if #2 (hd d) = m
      then hd d :: dates_in_month(tl d, m)
      else dates_in_month(tl d, m);

fun dates_in_months (d: (int * int * int) list, m: int list) =
  if null m
  then []
  else dates_in_month(d, hd m) @ dates_in_months(d, tl m);

fun get_nth (strings: string list, n: int): string =
  if n = 1
  then hd strings
  else get_nth(tl strings,n-1);

fun date_to_string (date: int * int * int): string =
  let
      val month = ["January", "February", "March", "April", "May", "June","July","August","September","October","November","December"]
  in
	  get_nth(month, #2 date) (** append month in English **)
      ^ " " ^ Int.toString(#3 date) (** append date **)
      ^ ", " ^ Int.toString(#1 date) (** append year **)
  end;

val test6 = get_nth (["hi", "there", "how", "are", "you"], 2)
val test7 = date_to_string (2013, 6, 1)
