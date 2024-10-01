fun main() {
    data class Dice(val faces: MutableList<Int> = MutableList(6) { index -> 1 + index })
    println("Welcome to Pig! The goal is to reach 100 points before your opponent\nRoll one dice at a time, and its value will be added to your score\nIf you roll a one, you lose all points for that round\n\n")
    val die1 = Dice()
    while (true) {
        var p1Score = 0
        var trueP1Score = 0
        var p2Score = 0
        var trueP2Score = 0
        var p1Turn: Boolean
        var p2Turn: Boolean
        var win = false
        fun winCheck() {
            if (trueP1Score >= 100) {
                println("Player 1 wins!")
                win = true
            }
            if (trueP2Score >= 100) {
                println("Player 2 wins!")
                win = true
            }
        }
        while (!win) {
            Thread.sleep(1000)
            p1Turn = true
            println("Player 1's turn")
            while (p1Turn) {
                println("Enter 1 to roll, enter 0 to end your turn")
                val choice = readln().toInt()
                Thread.sleep(500)
                when (choice) {
                    1 -> {
                        val roll = die1.faces.random()
                        println("You rolled a $roll")
                        when (roll) {
                            2 -> p1Score += 2
                            3 -> p1Score += 3
                            4 -> p1Score += 4
                            5 -> p1Score += 5
                            6 -> p1Score += 6
                            1 -> {
                                println("You rolled a one; your turn is over")
                                p1Score = 0
                                p1Turn = false
                            }
                        }
                    }
                    0 -> p1Turn = false
                }
            }
            trueP1Score += p1Score
            p1Score = 0
            println("Player 1's score is now $trueP1Score\n")
            winCheck()
            if (!win) {
                p2Turn = true
                Thread.sleep(1000)
                println("Player 2's turn")
                while (p2Turn) {
                    println("Enter 1 to roll, enter 0 to end your turn")
                    val choice = readln().toInt()
                    Thread.sleep(500)
                    when (choice) {
                        1 -> {
                            val roll = die1.faces.random()
                            println("You rolled a $roll")
                            when (roll) {
                                2 -> p2Score += 2
                                3 -> p2Score += 3
                                4 -> p2Score += 4
                                5 -> p2Score += 5
                                6 -> p2Score += 6
                                1 -> {
                                    println("You rolled a one; your turn is over")
                                    p2Score = 0
                                    p2Turn = false
                                }
                            }
                        }

                        0 -> p2Turn = false
                    }
                }
                trueP2Score += p2Score
                p2Score = 0
                println("Player 2's score is now $trueP2Score\n")
                winCheck()
            }
        }
        Thread.sleep(1000)
        println("Resetting scores...")
        Thread.sleep(1000)
    }
}
