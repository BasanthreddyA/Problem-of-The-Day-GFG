<h2><a href="https://practice.geeksforgeeks.org/problems/winner-of-an-election-where-votes-are-represented-as-candidate-names-1587115621/1?page=1&status[]=unsolved&company[]=Atlassian&company[]=Uber&sortBy=submissions">Winner of an election</a></h2><h3>Difficulty Level : Easy</h3><hr><div class="problems_problem_content__Xm_eO"><p><span style="font-size:18px">Given an array of names (consisting of lowercase characters) of candidates in an election. A candidate name in array represents a vote casted to the candidate. Print the name of candidate that received Max votes. If there is tie, print lexicographically smaller name.</span></p>

<p><span style="font-size:18px"><strong>Example 1:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input:
</strong>n = 13
Votes[] = {john,johnny,jackie,johnny,john 
jackie,jamie,jamie,john,johnny,jamie,
johnny,john}
<strong>Output: </strong>john 4<strong>
Explanation: </strong>john has 4 votes casted for 
him, but so does johny. john is 
lexicographically smaller, so we print 
john and the votes he received.</span></pre>

<p><span style="font-size:18px"><strong>Example 2:</strong></span></p>

<pre><span style="font-size:18px"><strong>Input:
</strong>n = 3
Votes[] = {andy,blake,clark}
<strong>Output: </strong>andy 1<strong>
Explanation: </strong>All the candidates get 1 
votes each. We print andy as it is 
lexicographically smaller.</span>
</pre>

<p><span style="font-size:18px"><strong>Your Task:</strong><br>
You only need to complete the function&nbsp;<strong>winner()</strong>&nbsp;that takes an array of strings&nbsp;arr, and n as parameters&nbsp;and&nbsp;returns&nbsp;the name of the&nbsp;candiate with maximum votes and the number of votes the candidate got as an array&nbsp;of size 2.</span></p>

<p><span style="font-size:18px"><strong>Expected Time Complexity:&nbsp;</strong>O(n)<br>
<strong>Expected Auxiliary Space:&nbsp;</strong>O(n)</span></p>

<p><span style="font-size:18px"><strong>Constraints:</strong><br>
1 &lt;= n&nbsp;&lt;= 10<sup>5</sup></span></p>
</div><p><span style=font-size:18px><strong>Company Tags : </strong><br><code>Adobe</code>&nbsp;<code>Atlassian</code>&nbsp;<br><p><span style=font-size:18px><strong>Topic Tags : </strong><br><code>Hash</code>&nbsp;<code>Strings</code>&nbsp;<code>Data Structures</code>&nbsp;