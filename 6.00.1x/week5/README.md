# Week 5 - Object Oriented Programming

Problem set 5 for week 5

# Requirements

## The Caesar Cipher

The idea of the Caesar Cipher is to pick an integer and shift every letter of your message by that integer. In other words, suppose the shift is k . Then, all instances of the i-th letter of the alphabet that appear in the plaintext should become the (i+k)-th letter of the alphabet in the ciphertext. You will need to be careful with the case in which i + k > 26 (the length of the alphabet). Here is what the whole alphabet looks like shifted three spots to the right:

```
Original:  a b c d e f g h i j k l m n o p q r s t u v w x y z
 3-shift:  d e f g h i j k l m n o p q r s t u v w x y z a b c
```

Using the above key, we can quickly translate the message "happy" to "kdssb" (note how the 3-shifted alphabet wraps around at the end, so x -> a, y -> b, and z -> c).

**Note!! We are using the English alphabet for this problem - that is, the following letters in the following order:**

> > > import string
> > > print string.ascii_lowercase
> > > abcdefghijklmnopqrstuvwxyz

We will treat uppercase and lowercase letters individually, so that uppercase letters are always mapped to an uppercase letter, and lowercase letters are always mapped to a lowercase letter. If an uppercase letter maps to "A", then the same lowercase letter should map to "a". Punctuation and spaces should be retained and not changed. For example, a plaintext message with a comma should have a corresponding ciphertext with a comma in the same position.

```
| plaintext       | shift     | ciphertext      |
| --------------- | --------- | --------------- |
| 'abcdef'        | 2         | 'cdefgh'        |
| 'Hello, World!' | 5         | 'Mjqqt, Btwqi!' |
| ''              | any value | ''              |
```

We implemented for you two helper functions: load_words and is_word. You may use these in your solution and you do not need to understand them completely, but should read the associated comments. You should read and understand the helper code in the rest of the file and use it to guide your solutions.

This will be your first experience coding with classes! We will have a Message class with two subclasses **PlaintextMessage** and **CiphertextMessage** .

## How to run

You can run my solutions by typing `python ./ps/ps6.py` in terminal.
