llvm-as "/home/yuli/Escritorio/LeMa 2.3/LeMa/archivo.ll"
opt -S "/home/yuli/Escritorio/LeMa 2.3/LeMa/archivo.ll"
llc "/home/yuli/Escritorio/LeMa 2.3/LeMa/archivo.bc"
gcc -o "/home/yuli/Escritorio/LeMa 2.3/LeMa/archivo" "/home/yuli/Escritorio/LeMa 2.3/LeMa/archivo.s"