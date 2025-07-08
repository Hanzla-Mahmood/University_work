.data 
space: .asciiz "\n"
.text 

li $t0,30

li $t1,6

div $t0,$t1

mflo $s0 # quotient

mfhi $s1 # remainder

# for quotient
li $v0,1
move $a0,$s0
syscall 

li $v0,4
la $a0,space
syscall 


  # for remainder
 li $v0,1
  move $a0,$s1
 syscall 