// https://godbolt.org/z/_FX4Tb
//
// -O0:   No optimisation, ASM looks "normal"
// -O3:   Vectorisation, ASM uses vector instructions and vector registers
// -O3 -fopt-info -fopt-info-vec-missed:  Log detailed optimisation information

#include <iostream>
#include <algorithm>
#include <cassert>

int main() {
  const int N = 256;
  int a[N], b[N], c[N];

  std::fill_n(a, N, 0);
  std::fill_n(b, N, 1);
  std::fill_n(c, N, 2);

  for (int i = 0; i < N; ++i) {
    a[i] = b[i] + c[i];
  }

  for (int i = 0; i < N; ++i) {
    assert(a[i] == 3);
  }

  std::cout << "It's all good\n";
}