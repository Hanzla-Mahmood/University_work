.data 

.text 
  addi $t0,$zero , 80000
  addi $t1,$zero, 223000
  mult $t0,$t1
  mflo $s0
  mfhi $s1
  
  li $v0,1
  add $a0,$zero,$s0
  syscall
  
    li $v0,1
  add $a0,$zero,$s1
  syscall
 