#include <stdio.h>
#include <stdlib.h>
struct Koza {
    double riritsu;
    int gankin;
};
void main(){
    struct Koza * newvar = (struct Koza *)malloc(sizeof(struct Koza));
    printf("%p\n", newvar);
    printf("%p\n", &(newvar->riritsu));
    printf("%p\n", &(newvar->gankin));







}