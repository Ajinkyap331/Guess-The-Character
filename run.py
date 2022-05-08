import subprocess
subprocess.call("javac -d . *.java", shell = True)
subprocess.call("javac Demo.java && java Demo", shell=True)