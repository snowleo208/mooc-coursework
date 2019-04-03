# Object Oriented Programming

## Objects

- each data type has a **type**
- objects are a data abstractions for internal data representation
- a set of procedures for interactions with the object

## Create your own object

- internal presentation should be **private**
- internal represenation directly: use defined interface
- distincion btw creating class and using instance

# Create class

1. define class name
2. define attributes

## Advantages of OOP

- bundle data into packages with well-defined interfaces
- divide-and-conquer development
  > you can implement and test separately
  > increase modularity and reduce complexity
- easy to reuse code
  > inheritance can redefine or extend a class
  > each class are separated: no collision on func names)

## Define your own type

```
class Coordinate(object):
    def __init__(self, x, y):
        self.x = x
        self.y = y
```

- Coordinate is a subclass of `object`
- object is a superclass of Coordinate

### Attributes

- data that belongs to that class
- procedural attributes (method)
  > method means functions that only work with this class
- use `__init__` to initialize data
- `self` is referring to an instance of the `class`

## Methods

```
class Coordinate(object):
    ...

    def distance(self, other):
        x_diff_sq = (self.x-other.x)**2
        y_diff_sq = (self.y-other.y)**2
        return (x_diff_sq + y_diff_sq)**0.5

c = Coordinate(3,4)
origin = Coordinate(0,0)
```

- can call as c.distance(origin)
- c inherits Coordinate class and automatically use c as self argument

## Representation of class

- can use `__str__` class to show info of class
- e.g. to show the definition of the class, print the coordinate of self

```
class Coordinate(object):
    ...

    def __str__(self):
        return "<" + str(self.x) + "," + str(self.y) + ">"

```

- use `isinstance` to check if an object is certain class, e.g. `isinstance(c, Coordinate)`
- can overwrite python's own method to represent certain result for your own class, e.g. `__len__`, `__str__`.

# Why OOP

- separate scope for data attributes and methods
- use **getter** to access data attributes, to separate internal representation (attributes) and actual use of representation (methods)
- user **setter** to amend data attributes

Reasons to use getter

> e.g. use `.get_age()` not `.age()`
> good style
> easy to maintain (maybe the owner wants to change the structure later)
> prevent bugs
> don't use `Animal.age = 12` directly even Python allows, always use getter and setter for best practices! :)

# Hierarchies

- subclass will use subclass's method, if you compare both object which are not in the same subclass may got Attribute Error.

## Hierarchies using in this case

Person
^
MITPerson
^
Student
^
Undergraduates / Transfer students / Graduates

### Substition Principle

- important behaviour of superclass **should be supported by all subclasses**

e.g. `Student` can have subclass of Undergraduates, transfer students and graduates. Student can be the subclasses of `MITPerson`, which have unique student id. In this case, you can add as many `Student` subclasses as possible, as all `Student` subclasses inherit attributes from `MITPerson`.

When you need attributes that needed to be shared between subclasses, create one more superclass to do so.

# Modularity

Isolating methods in class, make us easier to change its behaviour

> can change base behaviour in `MITPerson` class, as all subclasses inherit that method
> or change behaviour of a lower class in hierarchy, like from Undergraduates -> Student
> modularize: capture a behaviour locally, in its own class only
