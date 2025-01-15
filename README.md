# UWULANG 

A programming esolanguage oriented around the word UWU and its variations.

## 1. Installation

We don't currently support WINDOWS, but we do support MACOS/LINUX. A simple installation requires a Java compiler. To install, simply open a new terminal window and type:

```cd PATH/WHERE/UWULANG/WAS/INSTALLED && source uwulanginstaller.sh```

A successful output should be:
```
Created directory ~/Library/uwulang
Installed uwu source code
~/downloads/uwulang
Installed successfully.
```

## 2. Running
To run a program with a .uwu extension, simply type:

```uwu FULL/FILE/PATH/FILE.uwu```

## 3. Tutorial
UWULang is an interpreted language. There are 8 8-bit integers (0 to 127) allocated to the program's memory. Input is provided. The code is read using a pointer called memLoc, allowing for the program to print, read and write to memory.

UWULang has a special command set to allow programmers to manipulate memLoc:

```
UWU    moves memLoc up by 1 integer
UwU    moves memLoc down by 1 integer
uWU    reads an integer from standard input and writes it at memLoc
uwU    reads a char from standard input and writes it at memLoc in ASCII form
UWu    prints out the current integer at memLoc
Uwu    outputs the integer stored at memLoc as a character
owo    starts a loop
OWO    either ends the loop if integer at memLoc = 0, or moves back to the previous owo
uwu    adds 1 to the current integer at memLoc
uWu    subtracts 1 from the integer stored at memLoc
```

This code can be used to print hello world, the alphabet, multiply numbers, etc.

Feel free to make and share your own test programs!
