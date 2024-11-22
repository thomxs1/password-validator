# Password Validator

## Criteria


### Password must not be empty

You can't validate your password if the input is nothing.

### Password Length

You have to have a minimum length of 8 characters.

### No Spaces

Your password can't have spaces in it. (for example: "my password")

### One Uppercase and One Lowercase Letter

Your password has to have at least one Uppercase and Lowercase Letter.

### At least one Digit

You require at least one digit. (0-9)

### Special Character

Checks if you have at least one Special Character. ([]_!@#$%^&(),.?":{}|<>*)

### Name of one Bundesliga Club

Checks if you mentioned at least one Bundesliga Club in your password.

    "BayernMünchen", "BorussiaDortmund", "BayerLeverkusen", "VfLWolfsburg",
    "BorussiaMönchengladbach", "EintrachtFrankfurt", "UnionBerlin", "VfBStuttgart",
    "WerderBremen", "Mainz05", "SCFreiburg", "TSGHoffenheim", "FCAugsburg",
    "FCHeidenheim", "StPauli", "HolsteinKiel", "VfLBochum"

### One Song of Kanye Wests Album "Graduation"

Checks if you mentioned at least one Song of Kanye Wests album "Graduation".

    "GoodMorning", "Champion", "Stronger", "IWonder", "GoodLife", "CantTellMeNothing", 
    "BarryBonds", "DrunkAndHotGirls", "FlashingLights", "EverythingIAm", "TheGlory", 
    "Homecoming", "BigBrother", "GoodNight"

### First Name of a Course Member

Checks if you mentioned at least one Course Member of "Einführung in die Programmierung".

    "Kevin", "Willi", "Sören", "Nils", "Raphael", "Mikail", "Markus", "Timo", "Christine",
    "Celine", "Matthis", "Justus", "Josef", "Elias", "Yannick", "Niklas", "Adi", "Thomas",
    "Oliver", "Sinan", "Dietrich", "Tina", "Kim", "Vincent", "Luis", "Daniel", "Tim", 
    "Theocharis", "Marios"

### Password must not contain repeated Sequences of Identical Characters

Your password can't contain >= 3 Digits or Letters in a row. (for example: "aaapple")


## Valid Password Example 

Password: vfbstuttgart_goodmorningVincent1