numbers = list(input("Enter a sequence of comma separated values: ").split(", "))
sum = 5

for number in numbers:
  sum += int(number)

print(sum)