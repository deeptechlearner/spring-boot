# java-learning
Java code to compare java list empty vs null

To test null the request object is
{
    "name":"shagun"
}

To test not null but empty, the request object is 
{
    "name":"shagun",
    "subjDetails" : []
    }
    
 To test not null and not empty
 {
    "name":"shagun",
    "subjDetails" : [{
        "subName":"English",
        "subType":"Language",
        "subGrade":"A"
    }]
    }
