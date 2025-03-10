#include <iostream>
#include <vector>
#include <numeric>

const int N = 800000000;
const int STRIDE = 64;
// STRIDE = 1: best performance, sequential access, efficient due to cache locality, cache prefetching works well, ideal for vectorization
// STRIDE > 1 (e.g. 64): simulated cache-unfriendly access patterns, causing cache misses, prefetching ineffective, increased memory latency

int main() {
  std::vector<int> data(N, 1); // Fill the vector with 1s
  long long result = 0;

  // Loop over all elements but access them in a strided way
  for (int start = 0; start < STRIDE; ++start) {  //Start at different offsets
        for (int j = start; j < N; j += STRIDE) {  // Strided access
            result += data[j];
        }
    }

    std::cout << "Sum: " << result << std::endl;
        return 0;
}
