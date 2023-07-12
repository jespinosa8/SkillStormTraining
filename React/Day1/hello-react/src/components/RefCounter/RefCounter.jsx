import { useRef } from "react"
import RefInput from "./RefInput";

/**
 * REACT HOOK -useRef()
 *    similar to useState() because it gives us data that is persisted between re-renders
 *        however, it is NOT state. So changes to it do not update the view
 * 
 *    very usefull for things that are updated frequently
 * 
 */
export default function RefCounter() {

  const count  = useRef(0);     // creating a reference 'count' with a default value 0

  function increment () {

    // .current is the current value of the reference
    count.current++;
  }

  return (
    <>
      <div>
      {/** useRef does not create state, so this will not update unless the component re-renders */}
        RefCount = {count.current}

        <button onClick={increment}>+</button>
        <RefInput></RefInput>
      </div>

    </>
  )
}