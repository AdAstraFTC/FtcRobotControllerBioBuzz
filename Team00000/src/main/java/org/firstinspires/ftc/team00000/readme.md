# TeamCode Guide for Students

**From Coach Chris Lemoine**  
FTC Lead Coach & Programming Mentor  
Starbase, Texas

Hello everyone,

This guide is written to **all three of our FTC teams this season**. We are using a varsity / JV / sub-varsity structure to develop programmers across grades 6–12:

- **Primary Team (Varsity)** – Team 31192. This is our lead Android Studio team and the primary audience for this guide.
- **Secondary Team (JV)** – Our developing team. Students here are building foundational skills and will progress into Android Studio.
- **Third Tier Team (Sub-Varsity)** – Our newest or youngest team. Students here are learning core robotics and programming concepts and will move toward Android Studio as they grow.

**Our shared goal** is to build strong programming skills across all teams, with Android Studio as the long-term environment for serious robot control and collaboration. This document is your main technical reference for working in Android Studio. Mentors will support each team at their current level while helping everyone progress.

I will also be building my own robot and code in parallel this season. All of my files live in the `Team00000` module (you will see it in the project alongside your own team module). You can study my OpModes to see real working code in action. But remember: **your code must be your own work**. Use my examples to learn, not to copy.

Let’s get started the right way.

---

## Our Varsity / JV / Sub-Varsity Structure

We organize our program in three tiers so students in grades 6–12 can develop at an appropriate pace while still working together as one program:

- **Primary Team (Varsity)**: Team 31192 – Students focused on advanced Android Studio development, competition performance, and eventually mentoring newer programmers.
- **Secondary Team (JV)**: Developing programmers building strong fundamentals and moving steadily into Android Studio workflows.
- **Third Tier Team (Sub-Varsity)**: Newest or youngest students learning core concepts and gaining confidence before advancing to more complex tools.

**How This Guide Supports All Three Tiers**  
This document is written primarily for the Primary (Varsity) team working in Android Studio. However, the concepts, processes, and portfolio habits described here apply to everyone. Mentors will work with the Secondary and Third Tier teams at their current level while using this guide as the roadmap for progressing into full Android Studio development. Students on the Primary team are expected to master this material and may later help support newer teammates.

The goal is not to rush anyone, but to give every student a clear, supported path toward becoming confident robot programmers in the most powerful environment we have.

---

## 1. Where Your Code Lives

In our project there are two important modules:

- **FtcRobotController** — This contains the official FTC software and all the sample OpModes. **You should never edit anything inside this module.**
- **Your Team Module** (usually `TeamCode` or a numbered folder like `Team00000`) — This is where **your** code lives. Everything you write or copy goes here.

**Why this matters:** When the FTC SDK updates (which happens every season), the FtcRobotController module gets replaced. If you put your code there, it will be overwritten and lost. Your work stays safe inside your own team module.

**Portfolio Prompt #1**  
In your engineering notebook, draw a simple diagram showing the two modules. Label which one belongs to you. Write one sentence explaining why we keep our code separate.

---

## 2. How Sample OpModes Are Organized

The best way to start is by copying an official sample and making it your own. The samples are carefully written and commented so you can learn from them.

All samples live in:  
`FtcRobotController > java > org.firstinspires.ftc.robotcontroller > external > samples`

### Sample Naming System (Learn This — It Saves Time)

The file names follow a simple system so you can quickly find what you need:

| Prefix     | What It Shows                                      | Best Time to Use It                              | Example File Name                  |
|------------|----------------------------------------------------|--------------------------------------------------|------------------------------------|
| **Basic**  | The smallest possible working OpMode               | Your very first OpMode — learn the structure     | BasicOpMode_Linear                 |
| **Sensor** | How to read **one** specific sensor                | Testing new hardware (color sensor, distance, etc.) | SensorColor                        |
| **Robot**  | A simple drivetrain plus one main idea             | Building a basic driver-controlled robot         | RobotTeleopTank                    |
| **Concept**| One focused advanced topic                         | Learning vision, servos, PID, or localization    | ConceptVisionColorLocator          |

**Coach Advice:** Before you copy anything, open 2–3 different samples and read the comments at the top. In your notebook, write which prefix each one uses and what the OpMode is trying to teach. This habit will make you much faster at choosing the right starting point later in the season.

---

## 3. How to Copy a Sample into Your TeamCode (Step by Step)

Follow these steps exactly the first few times. After you’ve done it once or twice it becomes fast.

1. In Android Studio, make sure you are in the **Project** view (Android mode).
2. Expand this path:  
   `FtcRobotController > java > org.firstinspires.ftc.robotcontroller > external > samples`
3. Find the sample you want to use.
4. Right-click the `.java` file → **Copy**.
5. Now expand your own module:  
   `TeamCode > java > org.firstinspires.ftc.teamcode`
6. Right-click the `teamcode` folder → **Paste**.
7. Give your new file a clear, meaningful name.  
   Good examples: `TeleOp_BasicDrive`, `Auto_Park`, `Test_ColorSensor`  
   Start with a capital letter. No spaces.
8. Android Studio may ask if you want to refactor — usually say yes or let it do its thing.

**After you paste:**
- The very first line should still say `package org.firstinspires.ftc.teamcode;`
- If you see red error lines, go to the menu and choose **Build > Clean Project**, then **Build > Rebuild Project**.

**Common Mistakes to Avoid**
- Forgetting to rename the file (you end up with five files named “BasicOpMode_Linear”)
- Accidentally editing the file that is still inside FtcRobotController
- Not committing your changes to Git right after a successful paste

**Portfolio Prompt #2**  
Take a screenshot of your project tree after you have successfully pasted and renamed your first OpMode. Paste it into your notebook and label the file you created.

---

## 4. Making Your OpMode Appear on the Driver Station

After you copy a sample, it will **not** show up on the Driver Station until you make two small changes at the top of the file.

You will see lines that look like this near the top of the class:

```java
@TeleOp(name="Template: Linear OpMode", group="Linear OpMode")
@Disabled
```

Here is what you need to do:

1. Change the text inside `name="..."` to something clear that your drivers will understand.  
   Example: `name="TeleOp - Tank Drive v1"`
2. The `group="..."` helps organize the long list on the Driver Station. Common groups we use are: `"TeleOp"`, `"Autonomous"`, `"Test"`.
3. **Delete or comment out** the line that says `@Disabled`.  
   As long as that line is there, your OpMode will be hidden from the Driver Station.

Once you save the file and rebuild, your OpMode should appear when you select your team on the Driver Station.

**Coach Note:** My working OpModes for this season live in the `Team00000` module (right alongside your TeamCode module). You can study those files to see exactly how the annotations and structure should look in clean, working examples. Remember — use them to learn, not to copy.

---

## 5. Getting Help the Right Way (Mentor Bot & Human Mentors)

We have a powerful tool this season: the Mentor Bot. It can explain concepts, help you debug, and give you scaffolded next steps. But it only works well if you use it correctly.

### Good Ways to Ask the Mentor Bot for Help

- “Which sample prefix should I start with if I want to test our new distance sensor? Explain why without writing code for me.”
- “I copied the Basic Linear OpMode and added one motor. The motor spins the wrong direction. What questions should I ask myself to figure this out?”
- “Explain what `waitForStart()` and `opModeIsActive()` actually do in simple terms.”

### Rules for Using the Mentor Bot

1. You must describe what you have already tried.
2. Never paste an entire unsolved problem and say “fix it for me.”
3. After the bot gives you a hint, you must attempt it yourself before asking for more help.
4. Bring your notebook and what the bot told you to mentor check-ins.

I (Coach Chris) and the other mentors are also here to help. The same rules apply when you talk to us.

**Portfolio Prompt #3**  
Write down one good question you could ask the Mentor Bot right now about the OpMode you just copied. Then actually ask it and record the answer in your notebook.

---

## 6. Engineering Portfolio Expectations

Every time you create or significantly change an OpMode, you are expected to document it. This is not busy work — it is exactly what real engineers do and what judges look for.

**Minimum requirements for each OpMode:**

- Screenshot of the Android Studio project tree showing your new file
- Screenshot of the Driver Station showing your OpMode in the list
- Notebook entry that answers the Portfolio Prompts from this guide
- Short reflection: What did this OpMode teach you? What will you improve in the next version?
- (Later in the season) Link to the Git commit or GitHub compare view

I will be checking notebooks regularly. Teams that keep good portfolios almost always perform better at competition and in judging.

---

## Quick Reference Card (Print or Bookmark This)

**To Add a New OpMode:**
1. Choose the right sample using the Prefix Table.
2. Copy the file from the samples' folder.
3. Paste it into your team's module folder (TeamCode or your numbered team folder).
4. Rename the class with a clear name.
5. Edit the `@TeleOp(name=..., group=...)` line.
6. Remove the `@Disabled` line.
7. Build the project.
8. Document everything in your portfolio.

**Golden Rules**
- Never edit anything inside the FtcRobotController module.
- Commit to Git after every successful change.
- Use the Mentor Bot the right way.
- Your code must be your own work (my code in Team00000 is for learning, not copying).

---

## Final Coach Message

This season I am building my own robot at the same time you are. All of my code lives in the Team00000 module so you can see how a more experienced programmer organizes things and solves problems in real time. My goal is not to beat you — my goal is to push you to become better engineers than I was at your age.

Start by following this guide exactly. Copy one simple sample, get it running on the Driver Station, and document it well. Then we will move to more advanced concepts together.

I’m excited to see what you build.

— Coach Chris

---

**Document Version:** 2026 Season | This guide will be updated as needed. Always use the latest version from our shared resources. Questions about this guide? Bring them to the next programming meeting.