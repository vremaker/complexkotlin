
/* EXTRA CREDIT (and rant about the wikipedia game) 
    I've definetly spent far too much time playing the wikipedia game. 
    I used to play it a lot more when I was in middle school and had not yet discovered the 
    magic that would be memes and meme culture on platforms like reddit and tumblr. 
    AS FOR SENECA.... 
    WHO: A Roman Stoic philosopher, who was exiled by the emperor but then 
        returned to tutor Nero. He lost favor with Nero over time after Nero became a ruler 
        Seneca took his own life because he complicated was part of a conspiracy to kill nero (DOPE)
    WHAT DID HE STUDY: Stoic Philosophy 
    WHAT IS WHAT HE STUDY: A refinement of cynicism which teacher self control as 
    a means of controlling destructive emotions (but honestly self destructive emotions are kind of 
    fun, so why did he do that to himself?? )
 */

println("UW Complex Kotlin homework")

// write a lambda using map and fold to solve "FIZZBUZZ" for the first fifteen numbers (0..15)
// use map to return a list with "", "FIZZ" or "BUZZ" as necessary
// use fold to compress the array of strings down into a single string
// the final string should look like FIZZBUZZFIZZFIZZBUZZFIZZFIZZBUZZ
//

val mapFoldResults = (1..15)
.map { txt -> 
    if (txt % 3 == 0 && txt % 5 == 0) {
        "FIZZBUZZ"
    } else if (txt % 3 == 0) {
        "FIZZ"
    } else if (txt % 5 == 0) {
        "BUZZ"
    } else {
        ""
    }
}
.fold("", {previous, next -> "${previous}" + "${next}"})


// This is a utility function for your use as you choose, and as an
// example of an extension method
fun Int.times(block: () -> Unit): Unit {
    for (it in 1..this) {
        block()
    }
}

 // Use this function
fun process(message: String, block: (String) -> String): String {
    return ">>> ${message}: {" + block(message) + "}"
}
val r1 = process("FOO", {"BAR"}) 
val r2_message = "wooga"
val r2 = process("FOO", {r2_message.repeat(3).toUpperCase()})


 // write an enum-based state machine between talking and thinking
enum class Philosopher { 
    THINKING{
        override fun signal() = TALKING
        override fun toString(): String  {
            return "Deep thoughts...."
        }
    },  
    TALKING {
        override fun signal() = THINKING 
        override fun toString(): String {
            return "Allow me to suggest an idea..."
        }
    };
    abstract fun signal(): Philosopher
}
 
// create an class "Command" that can be used as a function (provide an "invoke()" function)
// that takes a single parameter ("message" of type String)
// primary constructor should take a String argument ("prompt")
// when called, the Command object should return a String containing the prompt and then the message
class Command(val prompt: String) {
    operator fun invoke(message: String) :String {
        return prompt + message; 
    }

}

//================================
println("map fold test: " + if (mapFoldResults == "FIZZBUZZFIZZFIZZBUZZFIZZFIZZBUZZ") "." else "!")

println("r1 test: " + if (r1 == ">>> FOO: {BAR}") "." else "!")
 
println("r2 test: " + if (r2 == ">>> FOO: {WOOGAWOOGAWOOGA}") "." else "!")

var seneca = Philosopher.THINKING
print("Seneca, talk! ")
seneca = seneca.signal()
println(if (seneca.toString() == "Allow me to suggest an idea...") "." else "!")
print("Seneca, think! ")
seneca = seneca.signal()
println(if (seneca.toString() == "Deep thoughts....") "." else "!")
print("Seneca, talk! ")  //THE FACT THAT THESE CONTAIN EXCLAIMATION POINTS STRESSED ME OUT xD 
seneca = seneca.signal()
println(if (seneca.toString() == "Allow me to suggest an idea...") "." else "!")

print("Command tests: ")
print(if (Command("")("") == "") "." else "!")
print(if (Command("> ")("Hello!") == "> Hello!") "." else "!")
println("")



