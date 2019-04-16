#  Week 7: Plotting

**all coding examples are from course materials**

## Pylab

Using Pylab to create graphs:

```python
import pylab as plt
```

### Create your first graph

```python
import pylab as plt

mySamples = []
myLinear = []
myQuadratic = []
myCubic = []
myExponential = []

for i in range(0, 30):
    mySamples.append(i)
    myLinear.append(i)
    myQuadratic.append(i**2)
    myCubic.append(i**3)
    myExponential.append(1.5**i)

plt.plot(mySamples, myLinear)
plt.plot(mySamples, myQuadratic)
plt.plot(mySamples, myCubic)
plt.plot(mySamples, myExponential)

```

### Label your graph

- must make figure active before making labels

```python

plt.figure('lin')
plt.clf() # clean the window

plt.title('Linear') # adding title

plt.xlabel('sample points')
plt.ylabel('linear function') # adding labels

plt.plot(mySamples, myLinear)

```

Use `plt.clf()` to clean the window, as PyLab would use the same windows, even for different graphs, thus the settings would be the same, e.g. color.

### Change scales

```python

plt.ylim(0, 1000) #limit y scale from 0 to 1000

```

### Add legends

```python
plt.plot(mySamples, myQuadratic, label='quadratic')
plt.legend.loc('upper left')

```

### Change display styles

```python

plt.plot(mySamples, myLinear, 'b-', label = 'linear') ''' blue line'''
plt.plot(mySamples, myQuadratic,'ro', label = 'quadratic')  ''' red dots'''

'''change line width'''
plt.plot(mySamples, myCubic, 'g--', label = 'cubic', linewidth= 4.0)
plt.plot(mySamples, myExponential, 'r',label= 'exponential', linewidth= 5.0)


'''change scales to log'''
plt.yscale('log')

```