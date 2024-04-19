#include <stdio.h>
#include <stdlib.h>

struct Koza        /* 預金口座構造体 */
{
    double riritsu; /* 利率 */
    int gankin;	    /* 元金 */
};

void Koza_syokika(struct Koza *koza) /* 預金口座構造体のメンバーを初期化する */
{
    koza->riritsu = 0.01;
}

double Koza_risoku(struct Koza *koza, int month) /* 利息を計算して返す */
{
    double kekka;
    kekka = (double)(koza->gankin) * (koza->riritsu) * (double)month / 12.0;
    return kekka;
}

int main(int argc, char *argv[])
{
    double kotae;

    struct Koza *my_koza;
    my_koza = malloc(sizeof(struct Koza));
    printf("my_kozaの値は %p\n", my_koza);
    Koza_syokika(my_koza);
    
    my_koza->gankin = 10000;
    kotae = Koza_risoku(my_koza, 6);
    printf("利息は%lf\n", kotae);
    
    exit(0);
}