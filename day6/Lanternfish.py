from collections import Counter

inputString = "4,5,3,2,3,3,2,4,2,1,2,4,5,2,2,2,4,1,1,1,5,1,1,2,5,2,1,1,4,4,5,5,1,2,1,1,5,3,5,2,4,3,2,4,5,3,2,1,4,1,3,1,2,4,1,1,4,1,4,2,5,1,4,3,5,2,4,5,4,2,2,5,1,1,2,4,1,4,4,1,1,3,1,2,3,2,5,5,1,1,5,2,4,2,2,4,1,1,1,4,2,2,3,1,2,4,5,4,5,4,2,3,1,4,1,3,1,2,3,3,2,4,3,3,3,1,4,2,3,4,2,1,5,4,2,4,4,3,2,1,5,3,1,4,1,1,5,4,2,4,2,2,4,4,4,1,4,2,4,1,1,3,5,1,5,5,1,3,2,2,3,5,3,1,1,4,4,1,3,3,3,5,1,1,2,5,5,5,2,4,1,5,1,2,1,1,1,4,3,1,5,2,3,1,3,1,4,1,3,5,4,5,1,3,4,2,1,5,1,3,4,5,5,2,1,2,1,1,1,4,3,1,4,2,3,1,3,5,1,4,5,3,1,3,3,2,2,1,5,5,4,3,2,1,5,1,3,1,3,5,1,1,2,1,1,1,5,2,1,1,3,2,1,5,5,5,1,1,5,1,4,1,5,4,2,4,5,2,4,3,2,5,4,1,1,2,4,3,2,1"

input = map(lambda x: int(x), inputString.split(','))

inputCounter = Counter(input)

def nextDay(currentDay):
  nextDay = Counter()
  for age, count in currentDay.items():
    newAge = age - 1
    if (newAge < 0):
      nextDay[6] += count
      nextDay[8] += count
    else:
      nextDay[newAge] += count
  return nextDay

dayN = inputCounter
for _ in range(256):
  dayN = nextDay(dayN)

print(dayN.total())