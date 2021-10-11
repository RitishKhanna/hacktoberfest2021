# Program to multiply two matrices using nested loops

# take a 3x3 matrix
A = [[1, 2, 3],
	[4, 5, 6],
	[7, 8, 9]]

# take a 3x4 matrix
B = [[2, 3, 5, 2],
	[7, 2, 3, 6],
	[8, 2, 7,01]]
	
result = [[0, 0, 0, 0],
		[0, 0, 0, 0],
		[0, 0, 0, 0]]

for i in range(len(A)):
	for j in range(len(B[0])):
		for k in range(len(B)):
			result[i][j] += A[i][k] * B[k][j]

for r in result:
	print(r)
