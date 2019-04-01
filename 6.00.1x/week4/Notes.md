# Week 4: Good Programming Practices

Week 4 is talking about testing and debug. How to write good program and using different testing methods.

## Main steps of programming:

- Defensive programming (Write specifications and check)
- Testing / Validation (Compare input and outputs)
- Debugging (Study the event and try to solve problems)

## Good pratices of programming and testing

- Modularize components
- Write documentations (What output is expected)
- assumptions behind the design (Why write func like this)

## Types of testing

- Unit testing
- Regression testing
- Integration testing

## Approaches

- Use intuition to find the problem (where might gone wrong)
- random testing (find out problem with many of tests)
- blackbox testing (explore paths through specifications)

  > design without looking at the code
  > can be reused
  > consider boundary situations (e.g. empty lists, small numbers, large numbers)

- glassbox testing (explore paths through code)
  > use the code directly
  > go through every code once
  > cons: may go through code many times (e.g. for-loop, while)
  > cons: may miss some lines (e.g. not entered in loops)
  > cons: may miss a bug, like edge cases

## Types of Bugs

- overt (code crashes, or run forever)
- covert (code runs ok, but may return incorrect value)
- persistent (occurs every time while code runs)
- intermittent (only occurs sometimes, even in the same input)

### overt & persistent

- easy and obvious
- can use defensive programming to protect

### overt & intermittent

- harder to debug
- can be handled if it can be reproduced

### covert

- dangerous
- hard to realize answer is incorrect for a long time

## Debugging

- use IDE tools
- use print statements
  > print when enter function
  > parameters
  > results
  > bisection method: print halfway in code

### About logic errors

- think before write
- draw the big picture
- explain your code to yourself or someone else clearly

### Step to debug

- study the code

  > ask how to get the **unexpected** answer
  > don't ask what is wrong
  > is it a series of bug?

- scientific method
  > study available data
  > repeat experiment
  > pick the simplest input to test with

## Exception

- try / except / finally
  > can use exception to create new flow, rather than just throw exception
  > e.g. rather than just throw error of 'no data', you can set data as 0 or any data you want to present
  > can use finally after finish all procedures without exceptions, like close the file

## Assertions

- use assert to do defensive programming, will raise AssertionError
  > can use to check input / outputs
  > make sure the execution halts
  > cannot control exception flows
