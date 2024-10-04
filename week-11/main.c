#include <stdio.h>
int main() {
    // Declare an array of 5 integers
    int arr[5] = {0, 1, 2, 3, 4};
    for (int i = 0; i <= 10; i++) {
        arr[i] = i;
        printf("arr[%d] = %d\n", i, arr[i]);
    }
    return 0;
}