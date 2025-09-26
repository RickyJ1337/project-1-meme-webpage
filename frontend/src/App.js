import './App.css';
import React, { useState } from 'react';

function App() {

  const [memeImage, setMemeImage] = useState(
      "https://picsum.photos/400/300?random=0"
    );

  const generateImage = () => {
    const randomNumber = Math.floor(Math.random() * 100);
    const randomWidth = Math.floor(Math.random() * 1000);
    const randomHeight = Math.floor(Math.random() * 1000);
    setMemeImage(`https://picsum.photos/${randomWidth}/${randomHeight}?random=${randomNumber}`);
  };

  return (
    <div className="App">
      <header className="Meme-title">
        <p>
          This is my Meme Generator App.
        </p>
      </header>
      <img
        src={memeImage}
        alt="Meme"
      />
      <button
        onClick={generateImage}
      >
        Generate Meme
      </button>
    </div>
  );
}

export default App;
