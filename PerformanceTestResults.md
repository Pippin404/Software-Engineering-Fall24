# Performance Testing Results

## Main Changes

* [Pull Request Link](https://github.com/Pippin404/Software-Engineering-Fall24/commit/9052ccf1ee49a435e8f064aa7b5ec422ab76dedf)

## Changes to the Implementation

* The InternalComputeEngine now contains a hashmap that saves already computed numbers:
* `private Map<Integer, Integer> memo = new HashMap<>();`
* The function computeNthFibonacci() first checks if the integer it is computing already has a result stored in the cache and uses the stored value if it does. If it does not, then the results of that computation are added to the cache:
* ```
  public int computeNthFibonacci(int i) {
        validateData(i);
        if (memo.containsKey(i)) {
            return memo.get(i);
        }

        int result = computeFib(i);
        memo.put(i, result);
        return result;
    }

## Test Results

* [Test File](https://github.com/Pippin404/Software-Engineering-Fall24/blob/9052ccf1ee49a435e8f064aa7b5ec422ab76dedf/src/server/ClientServer.java#L17)
* The following test was used to see the difference in time between the old and new implementation:
* ```
   // test speed
    long startTime1 = System.nanoTime();
    List<Integer> result1 = coordinator.runInternalCompute(coordinator.getData());
    long endTime1 = System.nanoTime();
    long duration1 = endTime1 - startTime1;
    System.out.println(duration1);

    long startTime2 = System.nanoTime();
    List<Integer> result2 = coordinator.runInternalComputev2(coordinator.getData());
    long endTime2 = System.nanoTime();
    long duration2 = endTime2 - startTime2;
    System.out.println(duration2);

    if (duration2 > duration1*1.1) {
        System.out.println("New Method is Faster");
    } else {
      System.out.println("New Method is Not Faster");
    }

    dataStore.setData(result2);
* The three tests produced the following runtimes:
  * New Compute Engine: 55286956ns, 52119148ns, 53459839ns
    * Average Runtime: 53621981ns
  * Old Compute Engine: 87479737ns, 86139046ns, 84311929ns
    * Average Runtime: 85976904ns
  * Percentage Change in Average Runtime: 37.6321% 
