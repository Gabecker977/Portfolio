using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class PickupObjects : Interactable
{   [SerializeField] private Transform parent;
    [SerializeField] private Image image;
    //Ao olhar para o objeto mostrar imagem de interação
    public override void OnFocus()
    {
        image.gameObject.SetActive(true);
    }
    //Ao interagir com o objeto "pegar" ele
    public override void OnInteract()
    {
    
        gameObject.transform.parent=parent;
        gameObject.GetComponent<Rigidbody>().useGravity=false;
        gameObject.GetComponent<Rigidbody>().drag=10;
        if(Input.GetKey(KeyCode.Mouse0))
            Thrown();
         //gameObject.GetComponent<Rigidbody>().AddForce(gameObject.transform.position-transform.forward,ForceMode.Impulse);
    }
    //Ao parar de interagir com o objeto "soltar" ele
    public override void OffInteract()
    {
        
        gameObject.transform.parent=null;
        gameObject.GetComponent<Rigidbody>().useGravity=true;
        gameObject.GetComponent<Rigidbody>().drag=1;
        //gameObject.GetComponent<Rigidbody>().AddExplosionForce(500f,parent.transform.forward,4f);
    }
    //Ao para de olhar para o objeto cancelar a interação e remover imagem de interação
    public override void OnLoseFocus()
    {
        gameObject.transform.parent=null;
        gameObject.GetComponent<Rigidbody>().useGravity=true;
        gameObject.GetComponent<Rigidbody>().drag=1;
         //print("Interagiu com "+gameObject.name);
         image.gameObject.SetActive(false);
         gameObject.GetComponent<Rigidbody>().AddExplosionForce(5f,parent.transform.forward,40f,0,ForceMode.Acceleration);
    }
    private void Thrown(){
        gameObject.transform.parent=null;
        gameObject.GetComponent<Rigidbody>().useGravity=true;
        gameObject.GetComponent<Rigidbody>().drag=1;
        gameObject.GetComponent<Rigidbody>().AddForce(parent.transform.forward*500);
    }
}
