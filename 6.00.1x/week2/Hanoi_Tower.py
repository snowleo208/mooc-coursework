count = 0

def Record(orig, target):
    """Print out record of moving disks
    orig -- the original position of disk
    target -- the target position of disk
    """
    global count
    print('move from ' + str(orig) + ' to ' + str(target) + ' | ' +str(count) + ' moves.')

def Tower(n, orig, target, spare):
    """Process Hanoi Tower
    n -- the number of disks
    orig -- the original position of disk
    target -- the target position of disk
    spare -- a spare tower for exchanging disk
    """
    global count
    if n == 1:
        count += 1
        return Record(orig, target)
    else:
        Tower(n-1, orig, spare, target)
        Tower(1, orig, target, spare)
        Tower(n-1, spare, target, orig)

Tower(4, 'P1', 'P2', 'P3')