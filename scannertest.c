//Our Test Program
//By: B&B

main()
{

//This is a comment.

/*This is a comment
 that spans several
 source lines.*/

Two /*comments*/ /*in a row*/ here

//Word tokens
Hello world
if If IF

//String tokens
"Hello, world."
"It's Friday!"
""
" "" "" "   """"""
"This string
spans
source lines."

//Special symbol tokens
+ - * / . , ; : = != < <= >= > ( ) [ ] { }
+-!==<==

//Special
99y9

//Number tokens
0 1 20 00000000000000000032  31415926
3.1415926  3.1415926535897932384626433
0.00031415926E4  0.00031415926e+00004  31415.926e-4
3141592600000000000000000000000e-30


//Bad tokens}=
123e99  123456789012345  1234.56E.  3. .14  314.e-2
What?
"String not closed

}