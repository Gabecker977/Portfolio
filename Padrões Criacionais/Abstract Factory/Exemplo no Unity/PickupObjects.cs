using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class PickupObjects : Interactable
{   [SerializeField] private Transform parent;
    [SerializeField] private Image image;
    //Ao olhar para o objeto mostrar imagem de interação
    public override void OnFocus(){
        image.gameObject.SetActive(true);
    }
    //Ao interagir com o objeto "pegar" ele
    public override void OnInteract(){
        gameObject.transform.parent=parent;
        gameObject.GetComponent<Rigidbody>().useGravity=false;
        gameObject.GetComponent<Rigidbody>().drag=10;
        if(Input.GetKey(KeyCode.Mouse0))
            Thrown();
    }
    //Ao parar de interagir com o objeto "soltar" ele
    public override void StopInteract(){
        gameObject.transform.parent=null;
        gameObject.GetComponent<Rigidbody>().useGravity=true;
        gameObject.GetComponent<Rigidbody>().drag=1;
    }
    //Ao para de olhar para o objeto cancelar a interação e remover imagem de interação
    public override void OnLoseFocus(){
        gameObject.transform.parent=null;
        gameObject.GetComponent<Rigidbody>().useGravity=true;
        gameObject.GetComponent<Rigidbody>().drag=1;
         image.gameObject.SetActive(false);
    }
    private void Thrown(){
        gameObject.transform.parent=null;
        gameObject.GetComponent<Rigidbody>().useGravity=true;
        gameObject.GetComponent<Rigidbody>().drag=1;
        gameObject.GetComponent<Rigidbody>().AddForce(parent.transform.forward*500);
    }
}
