fun is_older ((y1: int, m1: int, d1: int), (y2: int, m2: int, d2: int)) =
  if y1 = y2
  then
    if m1 = m2
    then d1 < d2 (** compare date if months are the same **)
    else m1 < m2 (** else compare month **)
  else y1 < y2 (** compare year **)

fun number_in_month (d: (int * int * int) list, m: int) =
  if null d
  then 0
  else
      if #2 (hd d) = m
      then number_in_month(tl d, m) + 1
      else number_in_month(tl d, m)

fun number_in_months (d: (int * int * int) list, m: int list) =
  if null m then 0
  else number_in_month(d, hd m) + number_in_months(d, tl m)

fun dates_in_month (d: (int * int * int) list, m: int) =
  if null d
  then []
  else
      if #2 (hd d) = m
      then hd d :: dates_in_month(tl d, m)
      else dates_in_month(tl d, m)

fun dates_in_months (d: (int * int * int) list, m: int list) =
  if null m
  then []
  else dates_in_month(d, hd m) @ dates_in_months(d, tl m)

fun get_nth (strings: string list, y: int) =
  if y = 1
  then hd strings
  else get_nth(tl strings, y-1)

fun date_to_string (date: int * int * int) =
  let
      val month = [ "January", "February", "March", "April","May", "June", "July", "August", "September", "October", "November", "December"]
  in
	  get_nth(month, #2 date) (** append month in English **)
      ^ " " ^ Int.toString(#3 date) (** append date **)
      ^ ", " ^ Int.toString(#1 date) (** append year **)
  end

fun number_before_reaching_sum (x: int, arr: int list) =
  if hd arr >= x
  then 0
  else number_before_reaching_sum(x - hd arr, tl arr) + 1

fun what_month (d: int): int =
  let
      val months_day = [31,28,31,30,31,30,31,31,30,31,30,31]
  in
      number_before_reaching_sum(d, months_day) + 1
  end

fun month_range(d1: int, d2: int) =
  if d1 > d2 then []
  else what_month(d1) :: month_range(d1 + 1, d2)

fun oldest (dates: (int * int * int) list) =
  if null dates
  then NONE
  else
    let
	    val oldest_result = oldest(tl dates)
    in
	    if isSome oldest_result andalso is_older(valOf oldest_result, hd dates)
	    then oldest_result
	    else SOME(hd dates)
    end
