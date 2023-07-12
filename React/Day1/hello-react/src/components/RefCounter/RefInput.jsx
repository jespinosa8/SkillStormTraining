import { useRef, useState } from "react";


export default function RefInput() {

  const inputRef = useRef();
  const [inputValue, setInputValue] = useState('');

  function handleSubmit() {
    /**
     * since inputRef is bound to the <input>, .current will return that tag
     *      so use .value to get the value of the input text
     */
    if(inputRef.current.value.includes('@')) {
      alert('Input cannot contain at sign (@).')

      /**
       * in general you should avoid using alert(). look into toast messages instead
       *    in react, you can use react-hot-toast
       * 
       * 
       */
    } else {
      alert('Input is valid');
    }
  }

  function handleInputChange(event) {

    if(!event.target.value.includes('@')) {

      // if the value of <input> tag ddoes NOT include @ then the state can change
      setInputValue(event.target.value);
    }
  }


  /**
   * CONTROLLED vs UNCONTROLLED COMPONENTS
   * 
   *    by default, native input tag is UNCONTROLLED
   *        uncontrolled means that react does not own it/have control over it
   *        we use useRef to get *some* control back
   * 
   *    Controlled components and elements are managed by react
   *      react decides what values they hold and when to hold them
   *      can use useState to turn an uncontrolled component into a controlled one  
   */

  return (
    <>
      <div>
      <label htmlFor="uncontrolled-input">Controlled Input</label>
        <input id="uncontrolled-input" value={inputValue} onChange={handleInputChange}/>

        <label htmlFor="controlled-input">Controlled Input</label>
        <input id="controlled-input" value={inputValue} onChange={handleInputChange}/>   {/** ref is going to bind the inputRef to the value of this tag */}

        <button onClick={handleSubmit}>Submit</button>

        
      </div>
    </>
  )
}