My system is easy to follow using the command line to input arguments.
3 lowercase letter denote which option you want to choose.
Although the txt files are there they are not used. Only in and out of the serialized file.
I used an ArrayList of individual class hashmaps. I like my implementation since it uses a familar data type across it's classes which make it easier to serialize by storing the hashmaps as the same type (map) in the ArrayList object.
Although I would not use serialized files in practice it was very easy to stream the objects in and out.

Consequences of the singleton pattern are like flexibility, access control, subclassing, and it is hard to work with when the ame object must be used in different objects at the same time.
A bridge pattern would have been nice to assist in deciding on what format of file to write to and from.
A factory method pattern would have been nice to create new objects of classes.
A facade could have been used for the ConsoleUserInterface and its subclasses.

Thank you and happy grading.