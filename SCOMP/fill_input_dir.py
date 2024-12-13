import random as rnd

path = "./input_dir/"

for i in range(1, 200):
    f1 = open(path + str(i) + "-candidate-data.txt", "w")
    f2 = open(path + str(i) + "-email.txt", "w")

    f1.write("JOB_REF_")
    for i in range(0, 2):
        r = chr(rnd.randint(65, 90))
        f1.write(r)
    f1.write("\nname")
    f1.close()

    f2.write("emaill\n")
    f2.close()

