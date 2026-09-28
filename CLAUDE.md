# Step_semester_3 workflow

Weekly Java coding assignments (STEP SEM-3, CodInClub). Follow this workflow for every new assignment PDF.

## Code layout

- Put solutions in `src/main/java/<topic>/assigment_problems/`, one topic folder per assignment (e.g. `polymorphism`, `encapsulation_and_access_control`).
- The folder name is spelled `assigment_problems` (one "s" missing). This is intentional and matches every existing topic folder. Do not "correct" it.
- Every Java file starts with a package declaration matching its path, e.g. `package polymorphism.assigment_problems;`.
- Each problem gets its own file with a public class named after the problem. Helper classes may be package-private in the same file. Keep the style of existing files: a Javadoc header such as `Week N - Problem M : Title`, no needless comments.

## Testing

- Read the PDF for the problems and sample inputs. If `pdftoppm` is missing, extract text with `pip install pypdf` and run Python with `PYTHONIOENCODING=utf-8` (the text contains the rupee sign).
- Compile and run every file with the PDF's sample input. Compare the output with the sample output before finishing. Report any mismatch.
- Compile into a temp directory (`javac -d $TEMP/...`), never into the repo.

## Git branching

- Start from `develop`: `git checkout develop`, then `git checkout -b feature/session_N`.
- Commit and push the code only to `feature/session_N`.
- Never merge feature branches into `main` or `develop`.
- Never commit code to `develop`.

## README entry on main

- After pushing the feature branch, switch to `main` and add a new entry at the top of `README.md`, directly under the `# Step_semester_3` title (newest first). Then commit and push `main`.
- Only `README.md` and `CLAUDE.md` are committed to `main`, never code.
- Entry format, with the date as DD-MM-YYYY:

```
## Date: 29-09-2026

**Today's Work:**
- Solved Week N ... problems (short list of the problems)
- Pushed to feature/session_N

**Next Session Plan:**
- Await next assignment set

**Issues Faced:**
- None

---
```

## Commit messages

End commit messages with the co-author line given in the session's attribution instructions.
