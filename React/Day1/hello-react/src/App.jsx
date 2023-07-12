import { useState } from "react";
import Counter from "./components/itemCounter/Counter";
import Item from "./components/itemCounter/Item";
import RefCounter from "./components/RefCounter/RefCounter";

// components are just functions
function App() {
  const [shouldRender, setShouldRender] = useState(true);
  
  return (
    <>
      <button onClick={() => setShouldRender(!shouldRender)}>Toggle Counter</button>

      {/* calling the counter component and displaying it here 
            these two counters have independent state
      
      */}
      {shouldRender ? <Counter/> : null} 
      {shouldRender && <Counter/>}

      <Item name='Puzzle' desc='100 pieces'>    {/** name and desc can be accessed in Item by calling props */}
        <p>Child!</p>
        {shouldRender && <RefCounter/>}
      </Item>
    </>
  );
}


/**
 * Exporting is how we make the component available to the rest of the app
 * 
 *    default exports
 *      uses the default keyword "export default..."
 *      only have one per file
 * 
 *    named exports
 *      simply uses export keyword only "export..."
 *      can have as many as you want
 *      need to be destructured when importing in other files
 *    
 */

// default export 
export default App;

// named exports
export const num = 10;

export const increment = () => {

}