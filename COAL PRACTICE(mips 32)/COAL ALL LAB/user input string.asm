.data 
 message1: .asciiz "My name is  \n"
 name:  .space 20
 
 .text 
   li $v0,8
   la $a0,name
   li $a1,20
   syscall
   
   
   li $v0,4
   la $a0,message1
   syscall
   
   li $v0,4
   la $a0,name
   syscall
   