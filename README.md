# joy-labs-challenge

### Running instructions  

**Console input**

Command: jlchallenge.<class name> “<input>”
  
*Examples:*

jlchallenge.ChronalCalibration “1, 1, 1”

jlchallenge.InventoryManagementSystem "aabb, abbba"

jlchallenge.ReposeRecordA "[1518-11-01 00:25] wakes up, [1518-11-01 00:05] falls asleep, [1518-11-01 00:00] Guard #10 begins shift"

**Config file input**

Command: jlchallenge.<class name>
  
Each class has its own .txt file (jlchallenge/src/main/resources/config/<ChallengeName.txt>) that contains an input. Personalized input can be added to that file. The input should start with / and each value should be in a different line.

*Examples: *

ChronalCalibration:  

/

+13

+4

-8

+11

+13

-12

InventoryManagementSystem:

/

cnjxpritdzhubeseewfmqagkul

cwyxpgitdzhvbosyewfmqagkul

cnfxpritdzhebosywwfmqagkul

cnjxpritdzgvbosyawfiqagkul

cnkxpritdzhvbosyewfmgagkuh

ReposeRecordA:

/

[1518-08-08 00:45] falls asleep

[1518-05-02 00:52] falls asleep

[1518-05-07 00:56] wakes up

[1518-08-18 00:06] falls asleep

[1518-11-11 00:04] Guard #2179 begins shift

[1518-09-15 00:38] wakes up

### Tests Instructions

**Test Cases**

Command: jlchallenge.<class name>Test
  
Example: jlchallenge.ChronalCalibrationTest

**Test Suite**

Command: jlchallenge.AllTests
