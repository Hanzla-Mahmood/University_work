.data
message1: .asciiz "Number is greater"
message2: .asciiz "Number is less"
.text
main:
  addi $t0,$zero,20
  addi $t1,$zero,10
  
 bgt $t0,$t1,greaternumber
 blt $t0,$t1,lessnumber
 
 greaternumber:
 li $v0,4
 la $a0,message1
 syscall
 
li $v0,10
syscall
 
 lessnumber:
 li $v0,4
 la $a0,message2
 syscall