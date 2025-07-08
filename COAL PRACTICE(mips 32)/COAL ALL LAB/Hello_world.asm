.data
  myMessage:  .asciiz  "Hellow world\n"
 .text
main:
   li $v0, 4
   la $a0, myMessage
   syscall

li $v0,10
syscall
