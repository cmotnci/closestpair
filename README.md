# Closest Pair of Points Problem

closestpair application is a spring boot application that helps to find distance between two points 
with using Divide and Conquer algorithm.

- User can provide multidimensional points via file

- Name of file is insignificant

- Every line of given file must contain one point's coordinates which is **x** and **y** coordinates.

- Both **x** and **y** coordiantes must be seperated by tab character

- Any given example single line should be as follows ;

  _-262972	508697_
  
# Explanation of solution

I implemented both Divide and Conquer algorithm and Naive strategy for comparing result times. 
If you try to find distance between two points from a small group of points, 
result should be very close for both way. Otherwise Divide and Conquer algorithm is making the difference.

Naive strategy is basic way to compare group of points. It compares like two for loop in nested and compares
every single point with each other.

Lets explain how Divide and Conquer algorithm works.

- First input array is sorted according to x coordinates.

- Find the middle point in the sorted array. Lets say P[n/2] as middle point.

- Divide the given array in two halves. The first subarray contains points from P[0] to P[n/2]. 
The second subarray contains points from P[n/2+1] to P[n-1]

- We will find the smallest distances in both left and right side of sorted array. 
Let the distances be dl and dr. Find the minimum of dl and dr. Let the minimum be d.

- Now we need to consider the pairs such that one point in pair is from left half and other is from right half. 
Consider the vertical line passing through P[n/2] and find all points whose x coordinate is 
closer than d to the middle vertical line. Build an array strip[] of all such points.

- Sort the array strip[] according to y coordinates and find the smallest distance in strip[].
    
# Using application
You can use application from http://13.59.246.218:8080

# Test files
You can find sample files under /resources/sample folder