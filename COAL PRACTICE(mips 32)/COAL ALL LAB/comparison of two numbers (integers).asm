.data 
message1: .asciiz "Number are equal\n"
message2: .asciiz "Number are not equal\n"

.text
 main:
   addi $t0,$zero,20
   addi $t1,$zero,20
   
   
   beq  $t0,$t1,numberequal
   bne $t0,$t1,notequal
   
   numberequal:
   li $v0,4
   la $a0,message1
   syscall
   
   li $v0,10
   syscall
   notequal:
   li $v0,4
   la $a0,message2
   syscall
