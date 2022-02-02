import sys
import numpy as np

NUMPOINTS = int(sys.argv[1])
PUVControl = int(sys.argv[2])
seed = int(sys.argv[3])

np.random.seed(seed)

X = np.random.normal(size=NUMPOINTS)
Y = np.random.normal(size=NUMPOINTS)

# All these lengths are greater than 0, I provided an arbitrary upper bound
lengthBound = 5
LENGTH1, RADIUS1, AREA1 = np.random.uniform(0, lengthBound, size=3)
DIST, LENGTH2, RADIUS2, AREA2 = np.random.uniform(0, lengthBound, size=4)

# epsilon's upper bound is pi
EPSILON = np.random.uniform(0, np.pi)

# See description
Q_PTS = np.random.randint(2, NUMPOINTS + 1)
QUADS = np.random.randint(1, 4)

# if NUMPOINTS < 3, N_PTS is not usable, so indicate that with -1
if (NUMPOINTS < 3):
    N_PTS = -1
else:
    N_PTS = np.random.randint(3, NUMPOINTS + 1)

# if NUMPOINTS < 3, K_PTS is not usable, so indicate that with -1
if (NUMPOINTS < 3):
    K_PTS = -1
else:
    K_PTS = np.random.randint(1, NUMPOINTS - 1)

# if NUMPOINTS < 5, A_PTS and B_PTS are not usable, so indicate that with -1
if (NUMPOINTS < 5):
    A_PTS = -1
    B_PTS = -1
else:
    A_PTS = np.random.randint(1, NUMPOINTS - 3)
    B_PTS = np.random.randint(1, NUMPOINTS - 2 - A_PTS)

# if NUMPOINTS < 5, C_PTS and D_PTS are not usable, so indicate that with -1
if (NUMPOINTS < 5):
    C_PTS = -1
    D_PTS = -1
else:
    C_PTS = np.random.randint(1, NUMPOINTS - 3)
    D_PTS = np.random.randint(1, NUMPOINTS - 2 - C_PTS)

# if NUMPOINTS < 5, E_PTS and F_PTS are not usable, so indicate that with -1
if (NUMPOINTS < 5):
    E_PTS = -1
    F_PTS = -1
else:
    E_PTS = np.random.randint(1, NUMPOINTS - 3)
    F_PTS = np.random.randint(1, NUMPOINTS - 2 - E_PTS)

# if NUMPOINTS < 3, G_PTS is not usable, so indicate that with -1
if (NUMPOINTS < 3):
    G_PTS = -1
else:
    G_PTS = np.random.randint(1, NUMPOINTS - 1)

LCM = [[0 for i in range(15)] for j in range(15)]
# We need 120 values to fill the bottom triangle of the matrix
# We do it like this becaues LCM is supposed to be symmetric
# 0 means ANDD, 1 means ORR, 2 means NOTUSEDD
LCMCore = [np.random.randint(0, 3) for i in range(120)]
coreIndex = 0
for i in range(15):
    for j in range(i + 1):
        LCM[i][j] = LCMCore[coreIndex]
        LCM[j][i] = LCMCore[coreIndex]
        coreIndex += 1

# Construct PUV manually.
# for example all 0 PUV means nothing is important.
# Will make testcases with only one PUV element 1 and others 0 for each index to test each LIC
PUV = [0] * 15

if (0 <= PUVControl and PUVControl < 15):
    PUV[PUVControl] = 1
elif (PUVControl == -1):
    PUV = [1] * 15

print(NUMPOINTS)
for i in range(NUMPOINTS):
    print("{:.4f} {:.4f}".format(X[i], Y[i]))

print("{:.4f}".format(LENGTH1))
print("{:.4f}".format(RADIUS1))
print("{:.4f}".format(EPSILON))
print("{:.4f}".format(AREA1))
print(Q_PTS)
print(QUADS)
print("{:.4f}".format(DIST))
print(N_PTS)
print(K_PTS)
print(A_PTS)
print(B_PTS)
print(C_PTS)
print(D_PTS)
print(E_PTS)
print(F_PTS)
print(G_PTS)
print("{:.4f}".format(LENGTH2))
print("{:.4f}".format(RADIUS2))
print("{:.4f}".format(AREA2))

for i in range(15):
    print(*LCM[i], sep=" ")

print(*PUV, sep=" ")
