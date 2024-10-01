fun main() {
    data class Dice(val faces: MutableList<Int> = MutableList(6) { index -> 1 + index }, var locked: Boolean = false)
    println("Welcome to Dice Dice Dice!\nYou have three tries to get a total of 21\nReady? Let's start!\n\n")
    Thread.sleep(1000)
    while (true) {
        val die1 = Dice()
        val die2 = Dice()
        val die3 = Dice()
        val die4 = Dice()
        val die5 = Dice()
        var d1Choice = die1.faces.random()
        var d2Choice = die1.faces.random()
        var d3Choice = die1.faces.random()
        var d4Choice = die1.faces.random()
        var d5Choice = die1.faces.random()
        var total = -1
        var turns = 0
        while (true) {
            if (die1.locked && die2.locked && die3.locked && die4.locked && die5.locked) {
                println("Your total: $total")
                if (total == 21) {
                    println("Congratulations! You won!")
                    break
                } else {
                    println("Sorry, you lost.")
                    break
                }
            }
            if (turns == 3) {
                println("Your total: $total")
                if (total == 21) {
                    println("Congratulations! You won!")
                    break
                } else {
                    println("Sorry, you lost.")
                    break
                }
            }
            if (!die1.locked) {
                d1Choice = die1.faces.random()
            }
            if (!die2.locked) {
                d2Choice = die2.faces.random()
            }
            if (!die3.locked) {
                d3Choice = die3.faces.random()
            }
            if (!die4.locked) {
                d4Choice = die4.faces.random()
            }
            if (!die5.locked) {
                d5Choice = die5.faces.random()
            }
            Thread.sleep(1000)
            println("Here is what you rolled:")
            if (!die1.locked) {
                println("Die 1: $d1Choice")
            } else println("Die 1: Locked")
            if (!die2.locked) {
                println("Die 2: $d2Choice")
            } else println("Die 2: Locked")
            if (!die3.locked) {
                println("Die 3: $d3Choice")
            } else println("Die 3: Locked")
            if (!die4.locked) {
                println("Die 4: $d4Choice")
            } else println("Die 4: Locked")
            if (!die5.locked) {
                println("Die 5: $d5Choice")
            } else println("Die 5: Locked")
            Thread.sleep(500)
            if (die1.locked || die2.locked || die3.locked || die4.locked || die5.locked) {
                println("Locked dice: ")
                if (die1.locked) {
                    println("Die 1: $d1Choice")
                }
                if (die2.locked) {
                    println("Die 2: $d2Choice")
                }
                if (die3.locked) {
                    println("Die 3: $d3Choice")
                }
                if (die4.locked) {
                    println("Die 4: $d4Choice")
                }
                if (die5.locked) {
                    println("Die 5: $d5Choice")
                }
            }
            total = d1Choice + d2Choice + d3Choice + d4Choice + d5Choice
            Thread.sleep(500)
            println("\nTotal: $total")
            Thread.sleep(750)
            while (true) {
                Thread.sleep(250)
                println("Enter 1 to lock the first die, 2 to lock the second die, etc.\nEnter 9 to lock all dice\nEnter 0 to reroll")
                val lockChoice = readln().toInt()
                when (lockChoice) {
                    1 -> die1.locked = true
                    2 -> die2.locked = true
                    3 -> die3.locked = true
                    4 -> die4.locked = true
                    5 -> die5.locked = true
                    9 -> {
                        die1.locked = true
                        die2.locked = true
                        die3.locked = true
                        die4.locked = true
                        die5.locked = true
                    }
                    0 -> break
                }
            }
            ++turns
        }
        Thread.sleep(1000)
        println("\nPolishing dice...\n")
        Thread.sleep(2000)
    }
}
