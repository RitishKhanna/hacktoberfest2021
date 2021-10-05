#include <stdio.h>
#include <sys/random.h>

int
randnum(int maxval)
{
  /* pick a random number from 1 to maxval */

  int randval;

  getrandom(&randval, sizeof(int), GRND_NONBLOCK);

  /* could be negative, so ensure it's positive */

  if (randval < 0) {
    return (-1 * randval % maxval + 1);
  }
  else {
    return (randval % maxval + 1);
  }
}
