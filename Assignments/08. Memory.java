/* Make a memory matching game.  It should include the following:
 * 
 * Splashscreen.
 * Start a game.
 * Computer shuffles and distributes cards, facedown, in a grid.
 * Player chooses a card, it flips over.
 * Player chooses a second card, if flips over.
 * If they match, cards "exit" the game (stay flipped over or move to side?)
 * If they don't match, the next click by the player, regardless of where, reverts the cards.
 * 
 * The player has a sequence of three clicks - first card, second card, revert.  Computer needs to track which we're on.
 * Each card has one of three values: Faceup (additional values based on size), Facedown, or Exited.

 * Extra optional things to add:
 * ~Easy/hard mode.  Hard mode has more cards.
 * ~Scoring.
 * 	When a player makes a match, score +10.
 * 	Game could keep track of how many times a cards is turned over.  If >2, score -5.
 * ~Button to side for rules.
 * ~Reset button: ask if easy or hard.
 * ~If hard mode, add a Joker card.  If clicked, it is removed from game but reveals all surrounding cards until next click.
 * 
 * Make sure to break this down into about 6-7 smaller tasks, such as
 * ~Splash & initial prompt
 * ~Initialization of arrays
 * ~Game display w/ score, rules, drawing cards
 * ~The actual design of faceup cards
 * ~Clicking cards to turn over
 * ~Evaluate match and possible exit
 * ~Joker card
 * ~What happens when the game ends
 * 
 * Paste the relevant code sections from PaintPalette for your code skeleton.
 */
