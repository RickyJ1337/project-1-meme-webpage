import './App.css';
import React, { useState, useEffect } from 'react';

function App() {

  const [memeList, setMemeList] = useState([]);
  const [memeImage, setCurrentMeme] = useState();

  useEffect(() => {
    fetch("https://api.imgflip.com/get_memes")
      .then((res) => res.json())
      .then((data) => {
        if (data.success) {
          setMemeList(data.data.memes);
          // Pick one meme initially
          setCurrentMeme(
            data.data.memes[Math.floor(Math.random() * data.data.memes.length)]
          );
        }
      });
  }, []);

  const generateMeme = () => {
    if (memeList.length > 0) {
      const randomIndex = Math.floor(Math.random() * memeList.length);
      setCurrentMeme(memeList[randomIndex]);
    }
  };

  return (
    <div className="App">
      <header className="Meme-title">
        <p>
          This is my Meme Generator App.
        </p>
      </header>
      <img
        src={memeImage.url}
        alt="Meme"
      />
      <button
        onClick={generateMeme}
      >
        Generate Meme
      </button>
    </div>
  );
}

export default App;
