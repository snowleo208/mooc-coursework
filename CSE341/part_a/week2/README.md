# Week 2

Our primary focus in this module will be on creating our own types: defining new types, building values of such types, and using those values. This will help us see that while pairs, lists, and options are "already provided" by ML, they do not really need to be: we could define our own versions that are just as powerful. We will also see a key distinction in how to think about "compound types" (types build out of smaller types), namely whether a compound type contains each of the smaller types or one of the smaller types.

We will also use pattern matching to access the pieces of values built out of compound types. ML-style pattern matching is extremely powerful and general, with several advantages over more conventional approaches. We will introduce the idea of syntactic sugar and see that ML is using pattern matching in every function binding and let expression even when it does not seem like it. This will be a key moment where you can see how a lot of what we have learned so far "fits together" elegantly to make ML a surprisingly small language at its core. We will also generalize the idea of pattern matching to support nested patterns. And we will briefly look at ML's exceptions, which also use pattern matching.

Finally, we will study tail recursion, which is the primary concept one needs to reason about the efficiency of ML programs, and in general any functional programs using recursion.

## Notes

Three most important type building-blocks in any languages:

- “Each of”: A t value contains values of each of t1 t2 … tn
- “One of”: A t value contains values of one of t1 t2 … tn
- “Self reference”: A t value can refer to other t values

### Example:

Tuples build each-of types

> int \* bool contains an int and a bool

Options build one-of types

> int option contains an int or it contains no data

Lists use all three building blocks

> int list contains an int and another int list or it contains no data

And of course we can nest compound types

> ((int _\* int) option _\* (int list list)) option

### Record

```ml
val x = { id= false, ego= false, superego= false};
```

Use `{}` to create a new record with its own type, in the example, its type is: `{id: bool, superego: bool, superego: bool}`.

Use `#superego x` to access its value.

#### Differences between turples and records

Little difference between (4,7,9) and {f=4,g=7,h=9}

- Tuples a little shorter
- Records a little easier to remember “what is where”
- Generally a matter of taste, but for many fields, a record is usually a better choice

### Syntactic Sugar

- Turples actually is record

```ml
val x = {1= true, 2=false}

val y = (true, false)

```

Both are the same in ML. In this case, `x` is bad styles.

### Case

Example:

```ml
fun f x = (* f has type mytype -> int *)
    case x of
        Pizza => 3
      | TwoInts(i1,i2) => i1+i2
      | Str s => String.size s
```

- A multi-branch conditional to pick branch based on variant
- Extracts data and binds to variables local to that branch
- Type-checking: all branches must have same type
- Evaluation: evaluate between case … of and the right branch

### Type

A datatype binding introduces a new type name
Distinct from all existing types
Only way to create values of the new type is the constructors

Example: `type aname = t`

### Option are datatypes

- Options are just a predefined datatype binding
- NONE and SOME are constructors, not just functions
- So use pattern-matching not isSome and valOf
  > No missing cases, no exceptions for wrong variant, etc.

Example:

```ml
fun inc_or_zero_intoption =
    case intoption of
        NONE => 0
      | SOME i => i + 1
```

### Nested patterns

- Nested patterns can lead to very elegant, concise code
- Avoid nested case expressions if nested patterns are simpler and avoid unnecessary branches or let-expressions

```ml
(* Example: avoid nested case expressions *)

fun zip3 list_triple =
    case list_triple of
	([],[],[]) => []
      | (hd1::tl1,hd2::tl2,hd3::tl3) => (hd1,hd2,hd3)::zip3(tl1,tl2,tl3)
      | _ => raise ListLengthMismatch

fun unzip3 lst =
    case lst of
	[] => ([],[],[])
      | (a,b,c)::tl => let val (l1,l2,l3) = unzip3 tl
		       in
			   (a::l1,b::l2,c::l3)
		       end
```

- A common idiom is matching against a tuple of datatypes to compare them
- Wildcards are good style: use them instead of variables when you do not need the data

```ml
(* Example: nested pattern-matching often convenient even without recursion;
   also the wildcard pattern is good style
*)
datatype sgn = P | N | Z

fun multsign (x1,x2) =
  let fun sign x = if x=0 then Z else if x>0 then P else N
  in
      case (sign x1,sign x2) of
	  (Z,_) => Z
	| (_,Z) => Z
	| (P,P) => P
	| (N,N) => P
	| _     => N (* many say bad style; I am okay with it *)
  end
```

### Exception

An exception binding introduces a new kind of exception

```ml
exception MyFirstException
exception MySecondException of int * int
```

The raise primitive raises (a.k.a. throws) an exception

```ml
raise MyFirstException
raise (MySecondException(7,9))
```

A handle expression can handle (a.k.a. catch) an exception

> If doesn’t match, exception continues to propagate

```ml
el handle MyFirstException => e2
el handle MySecondException(x,y) => e2
```

### Tail Recursion

There is a methodology that can often guide this transformation:

- Create a helper function that takes an accumulator
- Old base case becomes initial accumulator
- New base case becomes final accumulator

** beware list-append, especially within outer recursion **

> maybe no so efficient than you think
