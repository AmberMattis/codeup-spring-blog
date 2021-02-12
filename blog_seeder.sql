USE blog_db;

truncate posts;


INSERT INTO posts (id, title, body)
VALUE (1, 'The Nice Blogger','Hello, I am the nice blogger, I hope you like my blog, if not, no worries. I hope you have a wonderfull day. You are awesome, Bye.'),
      (2, 'The Rude Blogger','I did not give you permission to read my blog. Go away now, you are not worthy...I said go away!'),
      (3, 'The Shy blogger', '...');



Select * from posts;

