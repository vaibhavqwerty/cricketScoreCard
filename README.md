# cricketScoreCard

This is Cricket Score Managing Service.

This service expects provided inputs are correct.

APIs:

1. /demo/newGame [POST]
   this Api is for creating new game, required details are number of players per team, players name in order, number of overs.

   Example:
   request:
   localhost:8070/demo/newGame?numberOfPlayers=5&overPerTeam=2&membersTeam1=P1,P2,P3,P4,P5&membersTeam2=P6,P7,P8,P9,P10&battingTeam=1

   response:
   Successfully created new game


2. /demo/addRun [POST]
   this Api is for adding runs in games, expected input is comma seperated values.

   Example:
   request:
   localhost:8070/demo/addRun?runs=1,2,W,Wd
   response:
   Score updated Successfully

4. /demo/getScore [GET]

  Example:
  request:
  http://localhost:8070/demo/getScore
  response:
  {
    "playingTeam": "Team 2",
    "team": {
        "numberOfPlayers": 5,
        "listOfPlayers": [
            {
                "name": "P6",
                "balls": 0,
                "runs": 0,
                "fours": 0,
                "sixes": 0,
                "status": "out"
            },
            {
                "name": "P7",
                "balls": 0,
                "runs": 0,
                "fours": 0,
                "sixes": 0,
                "status": "notOut"
            },
            {
                "name": "P8",
                "balls": 0,
                "runs": 0,
                "fours": 0,
                "sixes": 0,
                "status": "notOut"
            },
            {
                "name": "P9",
                "balls": 0,
                "runs": 0,
                "fours": 0,
                "sixes": 0,
                "status": "notPlayed"
            },
            {
                "name": "P10",
                "balls": 0,
                "runs": 0,
                "fours": 0,
                "sixes": 0,
                "status": "notPlayed"
            }
        ],
        "totalScore": 0,
        "ballsPlayed": 1,
        "overPlayed": 0.1,
        "totalWicketsFallen": 1,
        "onStrikeName": "P8",
        "onNonStrikeName": "P7"
    }
}
